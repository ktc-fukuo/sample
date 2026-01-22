package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * ID連番マスタ一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Mb4IdbnSRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Mb4IdbnRegistForm.class);

    /** ID連番マスタ登録フォームのリスト */
    @Valid
    private List<Mb4IdbnRegistForm> mb4IdbnGrid;

    /**
     * @return ID連番マスタ登録フォームのリスト
     */
    public List<Mb4IdbnRegistForm> getMb4IdbnGrid() {
        return mb4IdbnGrid;
    }

    /**
     * @param p ID連番マスタ登録フォームのリスト
     */
    public void setMb4IdbnGrid(final List<Mb4IdbnRegistForm> p) {
        this.mb4IdbnGrid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mb4IdbnGrid.size(); i++) {
            Mb4IdbnRegistForm form = this.mb4IdbnGrid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Mb4IdbnGrid", i, gridErrors);
            }
        }
    }

}
