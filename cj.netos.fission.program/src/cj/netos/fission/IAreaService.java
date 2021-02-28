package cj.netos.fission;

import cj.netos.fission.model.Area;

import java.util.List;

public interface IAreaService {
    String _KEY_COL_LIMIT_AREA="fission.mf.limit.areas"   ;
    List<Area> listLimitArea(String unionid);

    Area getArea(String person, String direct);

}
