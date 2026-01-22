package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世明細一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6PrevDetSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6PrevDetRegistForm.class);

    /** 前世明細登録フォームのリスト */
    @Valid
    private List<Tb6PrevDetRegistForm> tb6PrevDetGrid;

    /**
     * @return 前世明細登録フォームのリスト
     */
    public List<Tb6PrevDetRegistForm> getTb6PrevDetGrid() {
        return tb6PrevDetGrid;
    }

    /**
     * @param p 前世明細登録フォームのリスト
     */
    public void setTb6PrevDetGrid(final List<Tb6PrevDetRegistForm> p) {
        this.tb6PrevDetGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6PrevDetGrid.size(); i++) {
            Tb6PrevDetRegistForm form = this.tb6PrevDetGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6PrevDetGrid", i, gridErrors);
            }
        }
    }

}
