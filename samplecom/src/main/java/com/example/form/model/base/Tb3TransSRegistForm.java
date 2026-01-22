package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変遷一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb3TransSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb3TransRegistForm.class);

    /** 変遷登録フォームのリスト */
    @Valid
    private List<Tb3TransRegistForm> tb3TransGrid;

    /**
     * @return 変遷登録フォームのリスト
     */
    public List<Tb3TransRegistForm> getTb3TransGrid() {
        return tb3TransGrid;
    }

    /**
     * @param p 変遷登録フォームのリスト
     */
    public void setTb3TransGrid(final List<Tb3TransRegistForm> p) {
        this.tb3TransGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb3TransGrid.size(); i++) {
            Tb3TransRegistForm form = this.tb3TransGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb3TransGrid", i, gridErrors);
            }
        }
    }

}
