package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 共生一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6KyoseiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6KyoseiRegistForm.class);

    /** 共生登録フォームのリスト */
    @Valid
    private List<Tb6KyoseiRegistForm> tb6KyoseiGrid;

    /**
     * @return 共生登録フォームのリスト
     */
    public List<Tb6KyoseiRegistForm> getTb6KyoseiGrid() {
        return tb6KyoseiGrid;
    }

    /**
     * @param p 共生登録フォームのリスト
     */
    public void setTb6KyoseiGrid(final List<Tb6KyoseiRegistForm> p) {
        this.tb6KyoseiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6KyoseiGrid.size(); i++) {
            Tb6KyoseiRegistForm form = this.tb6KyoseiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6KyoseiGrid", i, gridErrors);
            }
        }
    }

}
