package com.example.form.model.base;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.process.BaseProcess;
import jp.co.golorp.emarf.validation.IForm;

/**
 * 再帰登録フォーム
 *
 * @author emarfkrow
 */
public class Tb4SaikiRegistForm implements IForm {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(Tb4SaikiRegistForm.class);

    /** 再帰ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private String saikiId;

    /** @return 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public String getSaikiId() {
        return saikiId;
    }

    /** @param p 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setSaikiId(final String p) {
        this.saikiId = p;
    }

    /** 再帰名 */
    @jakarta.validation.constraints.NotBlank(groups = jp.co.golorp.emarf.validation.Regist.class)
    @jakarta.validation.constraints.Size(groups = jp.co.golorp.emarf.validation.Regist.class, max = 60)
    private String saikiMei;

    /** @return 再帰名 */
    public String getSaikiMei() {
        return saikiMei;
    }

    /** @param p 再帰名 */
    public void setSaikiMei(final String p) {
        this.saikiMei = p;
    }

    /** 参照ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String refId;

    /** @return 参照ID */
    public String getRefId() {
        return refId;
    }

    /** @param p 参照ID */
    public void setRefId(final String p) {
        this.refId = p;
    }

    /** 参照CD */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([\\-0-9A-Za-z]{1,10})?")
    private String refCd;

    /** @return 参照CD */
    public String getRefCd() {
        return refCd;
    }

    /** @param p 参照CD */
    public void setRefCd(final String p) {
        this.refCd = p;
    }

    /** 参照NO */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "([0-9]{1,10})?")
    private String refNo;

    /** @return 参照NO */
    public String getRefNo() {
        return refNo;
    }

    /** @param p 参照NO */
    public void setRefNo(final String p) {
        this.refNo = p;
    }

    /** 参照連番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String refBn;

    /** @return 参照連番 */
    public String getRefBn() {
        return refBn;
    }

    /** @param p 参照連番 */
    public void setRefBn(final String p) {
        this.refBn = p;
    }

    /** 別参照ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String exRefId;

    /** @return 別参照ID */
    public String getExRefId() {
        return exRefId;
    }

    /** @param p 別参照ID */
    public void setExRefId(final String p) {
        this.exRefId = p;
    }

    /** 別参照連番 */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String exRefBn;

    /** @return 別参照連番 */
    public String getExRefBn() {
        return exRefBn;
    }

    /** @param p 別参照連番 */
    public void setExRefBn(final String p) {
        this.exRefBn = p;
    }

    /** 親再帰ID */
    @jakarta.validation.constraints.Pattern(groups = jp.co.golorp.emarf.validation.Regist.class, regexp = "-?([0-9]{0,10}\\.?[0-9]{0,0}?)?")
    private String oyaSaikiId;

    /** @return 親再帰ID */
    public String getOyaSaikiId() {
        return oyaSaikiId;
    }

    /** @param p 親再帰ID */
    public void setOyaSaikiId(final String p) {
        this.oyaSaikiId = p;
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

        // 参照ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refIdParams = new java.util.HashMap<String, Object>();
        refIdParams.put("refId", this.getRefId());
        baseProcess.masterCheck(errors, "Mb4IdSearch", "refId", refIdParams, jp.co.golorp.emarf.util.Messages.get("Tb4Saiki.refId"));

        // 参照CD のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refCdParams = new java.util.HashMap<String, Object>();
        refCdParams.put("refCdFull", this.getRefCd());
        baseProcess.masterCheck(errors, "Mb4CdSearch", "refCd", refCdParams, jp.co.golorp.emarf.util.Messages.get("Tb4Saiki.refCd"));

        // 参照NO のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> refNoParams = new java.util.HashMap<String, Object>();
        refNoParams.put("refNoFull", this.getRefNo());
        baseProcess.masterCheck(errors, "Mb4NoSearch", "refNo", refNoParams, jp.co.golorp.emarf.util.Messages.get("Tb4Saiki.refNo"));

        // 別参照ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> exRefIdParams = new java.util.HashMap<String, Object>();
        exRefIdParams.put("exRefId", this.getExRefId());
        baseProcess.masterCheck(errors, "Mb4IdSearch", "exRefId", exRefIdParams, jp.co.golorp.emarf.util.Messages.get("Tb4Saiki.exRefId"));

        // 親再帰ID のマスタチェック TODO できればAssertTrueにしたい
        Map<String, Object> oyaSaikiIdParams = new java.util.HashMap<String, Object>();
        oyaSaikiIdParams.put("oyaSaikiId", this.getOyaSaikiId());
        baseProcess.masterCheck(errors, "Tb4SaikiSearch", "oyaSaikiId", oyaSaikiIdParams, jp.co.golorp.emarf.util.Messages.get("Tb4Saiki.oyaSaikiId"));
    }
}
