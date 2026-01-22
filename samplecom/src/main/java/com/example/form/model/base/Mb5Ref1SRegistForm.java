package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * マスタ参照１一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Mb5Ref1SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Mb5Ref1RegistForm.class);

    /** マスタ参照１登録フォームのリスト */
    @Valid
    private List<Mb5Ref1RegistForm> mb5Ref1Grid;

    /**
     * @return マスタ参照１登録フォームのリスト
     */
    public List<Mb5Ref1RegistForm> getMb5Ref1Grid() {
        return mb5Ref1Grid;
    }

    /**
     * @param p マスタ参照１登録フォームのリスト
     */
    public void setMb5Ref1Grid(final List<Mb5Ref1RegistForm> p) {
        this.mb5Ref1Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mb5Ref1Grid.size(); i++) {
            Mb5Ref1RegistForm form = this.mb5Ref1Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Mb5Ref1Grid", i, gridErrors);
            }
        }
    }

}
