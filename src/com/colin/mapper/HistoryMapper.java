package com.colin.mapper;

import com.colin.bean.History;

import java.util.List;

public interface HistoryMapper {
    void insertHistory(Integer leaveCourseid, String time, int sId, String sName, int tPay, int sPay);

    List<History> selectByCId(Integer courseid);

    List<History> selectLimitByCId(Integer courseid, int i);

    List<History> selectByCIdHistory(Integer courseid, String lookHistory);

    void deleteByCIdHistory(Integer courseid, String lookHistory);

    List<History> selectByCIdAndSId(Integer cId, int id);

    List<History> selectByCIdAndSIdLimit(Integer cId, int id, int i);

    List<History> selectByCIdGroup(Integer cId);

    List<History> selectByCIdGroupLimit(Integer cId, int i);
}
