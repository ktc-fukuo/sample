package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 寄生一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6KiseiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6KiseiRegistForm.class);

    /** 寄生登録フォームのリスト */
    @Valid
    private List<Tb6KiseiRegistForm> tb6KiseiGrid;

    /**
     * @return 寄生登録フォームのリスト
     */
    public List<Tb6KiseiRegistForm> getTb6KiseiGrid() {
        return tb6KiseiGrid;
    }

    /**
     * @param p 寄生登録フォームのリスト
     */
    public void setTb6KiseiGrid(final List<Tb6KiseiRegistForm> p) {
        this.tb6KiseiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6KiseiGrid.size(); i++) {
            Tb6KiseiRegistForm form = this.tb6KiseiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6KiseiGrid", i, gridErrors);
            }
        }
    }

}
