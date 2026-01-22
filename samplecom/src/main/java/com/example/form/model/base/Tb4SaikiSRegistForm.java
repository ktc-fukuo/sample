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
public class Tb4SaikiSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb4SaikiRegistForm.class);

    /** 再帰登録フォームのリスト */
    @Valid
    private List<Tb4SaikiRegistForm> tb4SaikiGrid;

    /**
     * @return 再帰登録フォームのリスト
     */
    public List<Tb4SaikiRegistForm> getTb4SaikiGrid() {
        return tb4SaikiGrid;
    }

    /**
     * @param p 再帰登録フォームのリスト
     */
    public void setTb4SaikiGrid(final List<Tb4SaikiRegistForm> p) {
        this.tb4SaikiGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb4SaikiGrid.size(); i++) {
            Tb4SaikiRegistForm form = this.tb4SaikiGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb4SaikiGrid", i, gridErrors);
            }
        }
    }

}
