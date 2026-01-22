package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 複合２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb5Comp2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb5Comp2RegistForm.class);

    /** 複合２登録フォームのリスト */
    @Valid
    private List<Tb5Comp2RegistForm> tb5Comp2Grid;

    /**
     * @return 複合２登録フォームのリスト
     */
    public List<Tb5Comp2RegistForm> getTb5Comp2Grid() {
        return tb5Comp2Grid;
    }

    /**
     * @param p 複合２登録フォームのリスト
     */
    public void setTb5Comp2Grid(final List<Tb5Comp2RegistForm> p) {
        this.tb5Comp2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb5Comp2Grid.size(); i++) {
            Tb5Comp2RegistForm form = this.tb5Comp2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb5Comp2Grid", i, gridErrors);
            }
        }
    }

}
