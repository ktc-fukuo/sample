package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * マスタ参照２一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Mb5Ref2SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Mb5Ref2RegistForm.class);

    /** マスタ参照２登録フォームのリスト */
    @Valid
    private List<Mb5Ref2RegistForm> mb5Ref2Grid;

    /**
     * @return マスタ参照２登録フォームのリスト
     */
    public List<Mb5Ref2RegistForm> getMb5Ref2Grid() {
        return mb5Ref2Grid;
    }

    /**
     * @param p マスタ参照２登録フォームのリスト
     */
    public void setMb5Ref2Grid(final List<Mb5Ref2RegistForm> p) {
        this.mb5Ref2Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mb5Ref2Grid.size(); i++) {
            Mb5Ref2RegistForm form = this.mb5Ref2Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Mb5Ref2Grid", i, gridErrors);
            }
        }
    }

}
