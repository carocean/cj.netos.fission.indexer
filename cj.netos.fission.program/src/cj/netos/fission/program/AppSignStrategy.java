package cj.netos.fission.program;

import cj.studio.ecm.IServiceSite;
import cj.studio.openport.CheckAppSignException;
import cj.studio.openport.DefaultSecuritySession;
import cj.studio.openport.ICheckAppSignStrategy;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.util.Encript;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class AppSignStrategy implements ICheckAppSignStrategy {
    String appid;
    String appKey;
    String appSecret;

    @Override
    public ISecuritySession checkAppSign(String portsurl, String methodName, String appId, String appKey, String nonce, String sign) throws CheckAppSignException {
        if (!appId.equals(this.appid)) {
            throw new CheckAppSignException("802", "app验证失败，拒绝访问，原因：应用不被信任");
        }
        if (!appKey.equals(this.appKey)) {
            throw new CheckAppSignException("803", "app验证失败，拒绝访问，原因：公钥不匹配");
        }
        String genSign = Encript.md5(String.format("%s%s%s", appKey, nonce, this.appSecret));
        if (!genSign.equals(sign)) {
            throw new CheckAppSignException("804", "app验证失败，拒绝访问，原因：签名不正确");
        }
        ISecuritySession securitySession = new DefaultSecuritySession(appId);
        return securitySession;
    }

    @Override
    public void init(IServiceSite site) {
        appid = site.getProperty("appid");
        appKey = site.getProperty("appKey");
        appSecret = site.getProperty("appSecret");
        OkHttpClient client = new OkHttpClient().newBuilder().readTimeout(60, TimeUnit.SECONDS).build();
        site.addService("@.http", client);
    }
}
