package com.git.opengds.generalization.service;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.git.gdsbuilder.generalization.rep.DTGeneralReport;
import com.git.opengds.generalization.dbManager.GenResultDBQueryManager;
import com.git.opengds.generalization.persistance.GeneralizationReportDAO;
import com.git.opengds.user.domain.UserVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("generalizationReportService")
public class GeneralizationReportServiceImpl extends EgovAbstractServiceImpl implements GeneralizationReportService {

	@Resource(name="generalizationReportDAO")
	GeneralizationReportDAO generalizationReportDAO;

	@Override
	public boolean insertGenralResult(UserVO userVO, String collectionName, String layerName, String genTbName,
			DTGeneralReport resultReport) {

		try {
			GenResultDBQueryManager queryManager = new GenResultDBQueryManager();
			HashMap<String, Object> insertQuery = queryManager.getInsertGenResultQuery(collectionName, layerName,
					genTbName, resultReport);
			generalizationReportDAO.insertGenResult(userVO, insertQuery);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
