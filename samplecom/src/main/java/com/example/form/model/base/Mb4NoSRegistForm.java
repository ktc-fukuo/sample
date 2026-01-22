package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * NOマスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Mb4NoSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Mb4NoRegistForm.class);

    /** NOマスタ登録フォームのリスト */
    @Valid
    private List<Mb4NoRegistForm> mb4NoGrid;

    /**
     * @return NOマスタ登録フォームのリスト
     */
    public List<Mb4NoRegistForm> getMb4NoGrid() {
        return mb4NoGrid;
    }

    /**
     * @param p NOマスタ登録フォームのリスト
     */
    public void setMb4NoGrid(final List<Mb4NoRegistForm> p) {
        this.mb4NoGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mb4NoGrid.size(); i++) {
            Mb4NoRegistForm form = this.mb4NoGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Mb4NoGrid", i, gridErrors);
            }
        }
    }

}
