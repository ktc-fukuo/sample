package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 再帰一覧登録フォーム
 *
 * @author emarfkrow
 */
public class T04SaikiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(T04SaikiRegistForm.class);

    /** 再帰登録フォームのリスト */
    @Valid
    private List<T04SaikiRegistForm> t04SaikiGrid;

    /**
     * @return 再帰登録フォームのリスト
     */
    public List<T04SaikiRegistForm> getT04SaikiGrid() {
        return t04SaikiGrid;
    }

    /**
     * @param p 再帰登録フォームのリスト
     */
    public void setT04SaikiGrid(final List<T04SaikiRegistForm> p) {
        this.t04SaikiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.t04SaikiGrid.size(); i++) {
            T04SaikiRegistForm form = this.t04SaikiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "T04SaikiGrid", i, gridErrors);
            }
        }
    }

}
