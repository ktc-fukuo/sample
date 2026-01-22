package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 寄生一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6Kisei2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6Kisei2RegistForm.class);

    /** 寄生登録フォームのリスト */
    @Valid
    private List<Tb6Kisei2RegistForm> tb6Kisei2Grid;

    /**
     * @return 寄生登録フォームのリスト
     */
    public List<Tb6Kisei2RegistForm> getTb6Kisei2Grid() {
        return tb6Kisei2Grid;
    }

    /**
     * @param p 寄生登録フォームのリスト
     */
    public void setTb6Kisei2Grid(final List<Tb6Kisei2RegistForm> p) {
        this.tb6Kisei2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6Kisei2Grid.size(); i++) {
            Tb6Kisei2RegistForm form = this.tb6Kisei2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6Kisei2Grid", i, gridErrors);
            }
        }
    }

}
