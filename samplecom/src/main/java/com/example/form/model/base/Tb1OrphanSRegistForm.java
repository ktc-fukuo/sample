package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 孤児一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb1OrphanSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb1OrphanRegistForm.class);

    /** 孤児登録フォームのリスト */
    @Valid
    private List<Tb1OrphanRegistForm> tb1OrphanGrid;

    /**
     * @return 孤児登録フォームのリスト
     */
    public List<Tb1OrphanRegistForm> getTb1OrphanGrid() {
        return tb1OrphanGrid;
    }

    /**
     * @param p 孤児登録フォームのリスト
     */
    public void setTb1OrphanGrid(final List<Tb1OrphanRegistForm> p) {
        this.tb1OrphanGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb1OrphanGrid.size(); i++) {
            Tb1OrphanRegistForm form = this.tb1OrphanGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb1OrphanGrid", i, gridErrors);
            }
        }
    }

}
