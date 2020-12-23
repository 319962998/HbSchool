package com.colin.service.impl;

import com.colin.bean.History;
import com.colin.mapper.HistoryMapper;
import com.colin.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.ext.MacArabic;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;
    @Override
    public void insertHistory(Integer leaveCourseid, String time, int sId, String sName, int tPay, int sPay) {
        historyMapper.insertHistory(leaveCourseid,time,sId,sName,tPay,sPay);
    }

    @Override
    public List<History> selectByCId(Integer courseid) {
        return historyMapper.selectByCId(courseid);
    }

    @Override
    public List<History> selectLimitByCId(Integer courseid, int i) {
        return historyMapper.selectLimitByCId(courseid,i);
    }

    @Override
    public List<History> selectByCIdHistory(Integer courseid, String lookHistory) {
        return historyMapper.selectByCIdHistory(courseid,lookHistory);
    }

    @Override
    public void deleteByCIdHistory(Integer courseid, String lookHistory) {
        historyMapper.deleteByCIdHistory(courseid,lookHistory);
    }

    @Override
    public List<History> selectByCIdAndSId(Integer cId, int id) {
        return historyMapper.selectByCIdAndSId(cId,id);
    }

    @Override
    public List<History> selectByCIdAndSIdLimit(Integer cId, int id, int i) {
        return historyMapper.selectByCIdAndSIdLimit(cId,id,i);
    }

    @Override
    public List<History> selectByCIdGroup(Integer cId) {
        return historyMapper.selectByCIdGroup(cId);
    }

    @Override
    public List<History> selectByCIdGroupLimit(Integer cId, int i) {
        return historyMapper.selectByCIdGroupLimit(cId,i);
    }
}
