package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 複合１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb5Comp1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb5Comp1RegistForm.class);

    /** 複合１登録フォームのリスト */
    @Valid
    private List<Tb5Comp1RegistForm> tb5Comp1Grid;

    /**
     * @return 複合１登録フォームのリスト
     */
    public List<Tb5Comp1RegistForm> getTb5Comp1Grid() {
        return tb5Comp1Grid;
    }

    /**
     * @param p 複合１登録フォームのリスト
     */
    public void setTb5Comp1Grid(final List<Tb5Comp1RegistForm> p) {
        this.tb5Comp1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb5Comp1Grid.size(); i++) {
            Tb5Comp1RegistForm form = this.tb5Comp1Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb5Comp1Grid", i, gridErrors);
            }
        }
    }

}
