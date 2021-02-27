package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.AbstractService;
import cj.netos.fission.ITagService;
import cj.netos.fission.model.LimitTag;
import cj.netos.fission.model.PropertyTag;
import cj.netos.fission.model.Tag;
import cj.studio.ecm.annotation.CjService;
import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.*;

@CjService(name = "tagService")
public class TagService extends AbstractService implements ITagService {
    @Override
    public List<Tag> listAllTag() {
        String cjql = String.format("select {'tuple':'*'}.sort({'tuple.sort':1}) from tuple %s %s where {}", _KEY_COL_TAGS, Tag.class.getName());
        IQuery<Tag> query = getHome().createQuery(cjql);
        List<IDocument<Tag>> documents = query.getResultList();
        List<Tag> tags = new ArrayList<>();
        for (IDocument<Tag> document : documents) {
            tags.add(document.tuple());
        }
        return tags;
    }

    @Override
    public void removePropTag(String unionid, String tagId) {
        getHome().deleteDocOne(_KEY_COL_PROP_TAGS, String.format("{'tuple.person':'%s','tuple.tag':'%s'}", unionid, tagId));
    }

    @Override
    public void selectPropTag(String unionid, String tagId) {
        if(getHome().tupleCount(_KEY_COL_PROP_TAGS,String.format("{'tuple.person':'%s','tuple.tag':'%s'}", unionid, tagId))>0){
            return;
        }
        PropertyTag propertyTag = new PropertyTag();
        propertyTag.setPerson(unionid);
        propertyTag.setTag(tagId);
        getHome().saveDoc(_KEY_COL_PROP_TAGS, new TupleDocument<>(propertyTag));
    }

    @Override
    public List<Tag> listPropTag(String unionid) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.person':'%s'}", _KEY_COL_PROP_TAGS, PropertyTag.class.getName(), unionid);
        IQuery<PropertyTag> query = getHome().createQuery(cjql);
        List<IDocument<PropertyTag>> documents = query.getResultList();
        List<String> tagIds = new ArrayList<>();
        for (IDocument<PropertyTag> document : documents) {
            tagIds.add(document.tuple().getTag());
        }
        return listTagIn(tagIds);
    }

    @Override
    public List<LimitTag> listLimitTag(String unionid) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.person':'%s'}", _KEY_COL_LIMIT_TAGS, LimitTag.class.getName(), unionid);
        IQuery<LimitTag> query = getHome().createQuery(cjql);
        List<IDocument<LimitTag>> documents = query.getResultList();
        List<LimitTag> limitTags = new ArrayList<>();
        for (IDocument<LimitTag> document : documents) {
            limitTags.add(document.tuple());
        }
        return limitTags;
    }

    @Override
    public List<Tag> listTagIn(List<String> tagIds) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.id':{'$in':%s}}", _KEY_COL_TAGS, Tag.class.getName(), new Gson().toJson(tagIds));
        IQuery<Tag> query = getHome().createQuery(cjql);
        List<IDocument<Tag>> documents = query.getResultList();
        List<Tag> tags = new ArrayList<>();
        for (IDocument<Tag> document : documents) {
            tags.add(document.tuple());
        }
        return tags;
    }

    @Override
    public List<String> searchPersonInPropTags(String unionid, List<String> tagIdList) {
        String cjql = String.format("select {'tuple.person':1}.distinct()  from tuple %s %s where {'tuple.person':{'$ne':'%s'},'tuple.tag':{'$in':%s}}", _KEY_COL_PROP_TAGS, String.class.getName(), unionid, new Gson().toJson(tagIdList));
        IQuery<String> query = getHome().createQuery(cjql);
        List<IDocument<String>> documents = query.getResultList();
        List<String> personIds = new ArrayList<>();
        for (IDocument<String> document : documents) {
            String personId = document.tuple();
            personIds.add(personId);
        }
        return personIds;
    }

    @Override
    public Set<String> searchPersonInPropTagsByPage(String unionid, List<String> tagIdList, int limit, long skip) {
        String cjql = String.format("select {'tuple':'*'}.limit(%s).skip(%s)  from tuple %s %s where {'tuple.person':{'$ne':'%s'},'tuple.tag':{'$in':%s}}", limit, skip, _KEY_COL_PROP_TAGS, PropertyTag.class.getName(), unionid, new Gson().toJson(tagIdList));
        IQuery<PropertyTag> query = getHome().createQuery(cjql);
        List<IDocument<PropertyTag>> documents = query.getResultList();
        Map<String, Object> personIds = new HashMap();
        for (IDocument<PropertyTag> document : documents) {
            String personId = document.tuple().getPerson();
            personIds.put(personId, true);
        }
        return personIds.keySet();
    }
}
