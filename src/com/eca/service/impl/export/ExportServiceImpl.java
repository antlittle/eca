package com.eca.service.impl.export;

import com.eca.dao.export.ExportDao;

public class ExportServiceImpl {
	private ExportDao exportDao;

	public ExportDao getExportDao() {
		return exportDao;
	}

	public void setExportDao(ExportDao exportDao) {
		this.exportDao = exportDao;
	}
}
