package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 前世一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb6PrevSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb6PrevRegistForm.class);

    /** 前世登録フォームのリスト */
    @Valid
    private List<Tb6PrevRegistForm> tb6PrevGrid;

    /**
     * @return 前世登録フォームのリスト
     */
    public List<Tb6PrevRegistForm> getTb6PrevGrid() {
        return tb6PrevGrid;
    }

    /**
     * @param p 前世登録フォームのリスト
     */
    public void setTb6PrevGrid(final List<Tb6PrevRegistForm> p) {
        this.tb6PrevGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb6PrevGrid.size(); i++) {
            Tb6PrevRegistForm form = this.tb6PrevGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb6PrevGrid", i, gridErrors);
            }
        }
    }

}
