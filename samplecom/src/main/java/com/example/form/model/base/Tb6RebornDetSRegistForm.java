package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 転生明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6RebornDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6RebornDetRegistForm.class);

    /** 転生明細登録フォームのリスト */
    @Valid
    private List<Tb6RebornDetRegistForm> tb6RebornDetGrid;

    /**
     * @return 転生明細登録フォームのリスト
     */
    public List<Tb6RebornDetRegistForm> getTb6RebornDetGrid() {
        return tb6RebornDetGrid;
    }

    /**
     * @param p 転生明細登録フォームのリスト
     */
    public void setTb6RebornDetGrid(final List<Tb6RebornDetRegistForm> p) {
        this.tb6RebornDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6RebornDetGrid.size(); i++) {
            Tb6RebornDetRegistForm form = this.tb6RebornDetGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6RebornDetGrid", i, gridErrors);
            }
        }
    }

}
