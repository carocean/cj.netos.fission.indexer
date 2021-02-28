package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.netos.fission.AbstractService;
import cj.netos.fission.IPersonService;
import cj.netos.fission.model.Person;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import com.mongodb.client.ListIndexesIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CjService(name = "personService")
public class PersonService extends AbstractService implements IPersonService {
    @Override
    public void createGeoIndex() {
        //为感知器和文档创建地理索引
        ListIndexesIterable<Document> itReceptorIndexes = getHome().listIndexes(_KEY_COL);
        boolean hasIndex = false;
        for (Document doc : itReceptorIndexes) {
            //是否存在索引，如果不存在则建立
            Map map = (Map) doc.get("key");
            Object v = map.get("tuple.location");
//                System.out.println(doc);
            if (v != null) {
//                    home.dropIndex(_getReceptorColName(category.getId()), Document.parse(String.format("{'tuple.location':1}")));
                CJSystem.logging().info(getClass(), String.format("发现用户表地理<%s>的索引：tuple.location=2dsphere", _KEY_COL));
                hasIndex = true;
                break;
            }
        }
        if (!hasIndex) {
            getHome().createIndex(_KEY_COL, Document.parse(String.format("{'tuple.location':'2dsphere'}")));
            CJSystem.logging().info(getClass(), String.format("已为用户表<%s>创建地理索引：tuple.location=2dsphere", _KEY_COL));
        }

    }

    @Override
    public List<Person> page(int limit, long offset) {
        String cjql = String.format("select {'tuple':'*'}.limit(%s).skip(%s) from tuple %s %s where {}", limit, offset, _KEY_COL, Person.class.getName());
        IQuery<Person> query = getHome().createQuery(cjql);
        List<IDocument<Person>> documents = query.getResultList();
        List<Person> persons = new ArrayList<>();
        for (IDocument<Person> document : documents) {
            persons.add(document.tuple());
        }
        return persons;
    }

    @Override
    public Person getPerson(String person) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.id':'%s'}", _KEY_COL, Person.class.getName(), person);
        IQuery<Person> query = getHome().createQuery(cjql);
        IDocument<Person> document = query.getSingleResult();
        if (document == null) {
            return null;
        }
        return document.tuple();
    }

    @Override
    public void updateProvince(String id, String province, String provinceCode) {
        String filter = String.format("{'tuple.id':'%s'}",id);
        String update = String.format("{'$set':{'tuple.province':'%s','tuple.provinceCode':'%s'}}",province,provinceCode);
        getHome().updateDocOne(_KEY_COL, Document.parse(filter), Document.parse(update));
    }

    @Override
    public void updateCity(String id, String city, String cityCode) {
        String filter = String.format("{'tuple.id':'%s'}",id);
        String update = String.format("{'$set':{'tuple.city':'%s','tuple.cityCode':'%s'}}",city,cityCode);
        getHome().updateDocOne(_KEY_COL, Document.parse(filter), Document.parse(update));
    }

    @Override
    public void updateDistrict(String id, String district, String districtCode) {
        String filter = String.format("{'tuple.id':'%s'}",id);
        String update = String.format("{'$set':{'tuple.district':'%s','tuple.districtCode':'%s'}}",district,districtCode);
        getHome().updateDocOne(_KEY_COL, Document.parse(filter), Document.parse(update));
    }
}
