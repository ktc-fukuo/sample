package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6RebornSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6RebornRegistForm.class);

    /** 転生登録フォームのリスト */
    @Valid
    private List<Tb6RebornRegistForm> tb6RebornGrid;

    /**
     * @return 転生登録フォームのリスト
     */
    public List<Tb6RebornRegistForm> getTb6RebornGrid() {
        return tb6RebornGrid;
    }

    /**
     * @param p 転生登録フォームのリスト
     */
    public void setTb6RebornGrid(final List<Tb6RebornRegistForm> p) {
        this.tb6RebornGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6RebornGrid.size(); i++) {
            Tb6RebornRegistForm form = this.tb6RebornGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6RebornGrid", i, gridErrors);
            }
        }
    }

}
