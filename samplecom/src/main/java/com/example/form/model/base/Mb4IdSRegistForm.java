package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * IDマスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Mb4IdSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Mb4IdRegistForm.class);

    /** IDマスタ登録フォームのリスト */
    @Valid
    private List<Mb4IdRegistForm> mb4IdGrid;

    /**
     * @return IDマスタ登録フォームのリスト
     */
    public List<Mb4IdRegistForm> getMb4IdGrid() {
        return mb4IdGrid;
    }

    /**
     * @param p IDマスタ登録フォームのリスト
     */
    public void setMb4IdGrid(final List<Mb4IdRegistForm> p) {
        this.mb4IdGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mb4IdGrid.size(); i++) {
            Mb4IdRegistForm form = this.mb4IdGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Mb4IdGrid", i, gridErrors);
            }
        }
    }

}
