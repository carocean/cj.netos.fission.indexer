package cj.netos.fission;

import cj.netos.fission.model.LimitTag;
import cj.netos.fission.model.Tag;

import java.util.List;
import java.util.Set;

public interface ITagService {
    public  static  String _KEY_COL_TAGS="fission.mf.tags";
    public  static  String _KEY_COL_PROP_TAGS="fission.mf.tags.properties";
    public  static  String _KEY_COL_LIMIT_TAGS="fission.mf.limit.tags";

    List<Tag> listAllTag();

    List<Tag> listPropTag(String unionid);
    List<LimitTag> listLimitTag(String unionid);
    List<Tag> listTagIn(List<String> tagIds);

    List<String> searchPersonInPropTags(String personId, List<String> tagIds);

    Set<String> searchPersonInPropTagsByPage(String personId, List<String> tagIds, int limit, long skip);

    void removePropTag(String unionid, String tagId);

    void selectPropTag(String unionid, String tagId);

}
