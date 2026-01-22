package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 親一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1OyaSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1OyaRegistForm.class);

    /** 親登録フォームのリスト */
    @Valid
    private List<Tb1OyaRegistForm> tb1OyaGrid;

    /**
     * @return 親登録フォームのリスト
     */
    public List<Tb1OyaRegistForm> getTb1OyaGrid() {
        return tb1OyaGrid;
    }

    /**
     * @param p 親登録フォームのリスト
     */
    public void setTb1OyaGrid(final List<Tb1OyaRegistForm> p) {
        this.tb1OyaGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1OyaGrid.size(); i++) {
            Tb1OyaRegistForm form = this.tb1OyaGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1OyaGrid", i, gridErrors);
            }
        }
    }

}
