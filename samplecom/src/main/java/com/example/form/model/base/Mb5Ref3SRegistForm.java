package com.example.form.model.base;

import java.util.List;
import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * マスタ参照３一覧登録フォーム
 *
 * @author emarfkrow
 */
public class Mb5Ref3SRegistForm implements IForm {

    // /** logger */
    // private static final Logger LOG = LoggerFactory.getLogger(Mb5Ref3RegistForm.class);

    /** マスタ参照３登録フォームのリスト */
    @Valid
    private List<Mb5Ref3RegistForm> mb5Ref3Grid;

    /**
     * @return マスタ参照３登録フォームのリスト
     */
    public List<Mb5Ref3RegistForm> getMb5Ref3Grid() {
        return mb5Ref3Grid;
    }

    /**
     * @param p マスタ参照３登録フォームのリスト
     */
    public void setMb5Ref3Grid(final List<Mb5Ref3RegistForm> p) {
        this.mb5Ref3Grid = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        for (int i = 0; i < this.mb5Ref3Grid.size(); i++) {
            Mb5Ref3RegistForm form = this.mb5Ref3Grid.get(i);
            if (form != null) {
                Map<String, String> gridErrors = new java.util.LinkedHashMap<String, String>();
                form.validate(gridErrors, baseProcess);
                BaseProcess.copyGridErrors(errors, "Mb5Ref3Grid", i, gridErrors);
            }
        }
    }

}
