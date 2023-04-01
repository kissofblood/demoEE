package com.example.frontend.controller;

import com.example.frontend.model.Company;
import com.example.frontend.service.IndexService;
import com.example.frontend.util.CDIUtil;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.Window;

public class IndexController extends GenericForwardComposer<Window> {

    @Wire private Grid gridCompany;
    @Wire private Grid gridBranch;

    private final IndexService indexService = CDIUtil.resolveBean(IndexService.class);

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        reload();
    }

    public void buttonReload() {
        reload();
    }

    public void onRowCompanyClick(Row row) {
        Company company = (Company) gridCompany.getModel().getElementAt(row.getIndex());
        gridBranch.setModel(indexService.findBranchByCompanyId(company.getId()));
    }

    private void reload() {
        indexService.generateCompanyData();
        gridCompany.setModel(indexService.findCompanyAll());
        gridBranch.setModel(new ListModelList<>());
    }
}
