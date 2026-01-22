package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変遷履歴一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Tb3TransHisSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Tb3TransHisRegistForm.class);

    /** 変遷履歴登録フォームのリスト */
    @Valid
    private List<Tb3TransHisRegistForm> tb3TransHisGrid;

    /**
     * @return 変遷履歴登録フォームのリスト
     */
    public List<Tb3TransHisRegistForm> getTb3TransHisGrid() {
        return tb3TransHisGrid;
    }

    /**
     * @param p 変遷履歴登録フォームのリスト
     */
    public void setTb3TransHisGrid(final List<Tb3TransHisRegistForm> p) {
        this.tb3TransHisGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.tb3TransHisGrid.size(); i++) {
            Tb3TransHisRegistForm form = this.tb3TransHisGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Tb3TransHisGrid", i, gridErrors);
            }
        }
    }

}
