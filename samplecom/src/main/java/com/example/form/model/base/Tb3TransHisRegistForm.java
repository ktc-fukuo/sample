package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 変遷履歴登録フォーム
 *
 * @author emarfkrow
 */
public class Tb3TransHisRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb3TransHisRegistForm.class);

    /** 変遷ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String transId;

    /** @return 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTransId() {
        return transId;
    }

    /** @param p 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTransId(final String p) {
        this.transId = p;
    }

    /** 変遷枝番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String transBn;

    /** @return 変遷枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getTransBn() {
        return transBn;
    }

    /** @param p 変遷枝番 */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTransBn(final String p) {
        this.transBn = p;
    }

    /** 変遷情報 */
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String transInfo;

    /** @return 変遷情報 */
    public String getTransInfo() {
        return transInfo;
    }

    /** @param p 変遷情報 */
    public void setTransInfo(final String p) {
        this.transInfo = p;
    }

    /** 変更理由 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 300)
    private String riyuTx;

    /** @return 変更理由 */
    public String getRiyuTx() {
        return riyuTx;
    }

    /** @param p 変更理由 */
    public void setRiyuTx(final String p) {
        this.riyuTx = p;
    }

    /** 更新タイムスタンプ */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{13}|[0-9]{4}(\\/|\\-)[0-9]{1,2}(\\/|\\-)[0-9]{1,2}(T| )[0-9]{1,2}:[0-9]{1,2}(:[0-9]{1,2}(\\.[0-9]{3})?)?)?")
    @jp.co.golorp.emarf.validation.OptLock
    private String updateTs;

    /** @return 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public String getUpdateTs() {
        return updateTs;
    }

    /** @param p 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final String p) {
        this.updateTs = p;
    }

    /** 関連チェック */
    @Override
    public void validate(final Map<String, String> errors, final BaseProcess baseProcess) {
        LOG.trace("validate() not overridden in subclasses.");
    }
}
