package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 子なし一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1DinksSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1DinksRegistForm.class);

    /** 子なし登録フォームのリスト */
    @Valid
    private List<Tb1DinksRegistForm> tb1DinksGrid;

    /**
     * @return 子なし登録フォームのリスト
     */
    public List<Tb1DinksRegistForm> getTb1DinksGrid() {
        return tb1DinksGrid;
    }

    /**
     * @param p 子なし登録フォームのリスト
     */
    public void setTb1DinksGrid(final List<Tb1DinksRegistForm> p) {
        this.tb1DinksGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1DinksGrid.size(); i++) {
            Tb1DinksRegistForm form = this.tb1DinksGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1DinksGrid", i, gridErrors);
            }
        }
    }

}
