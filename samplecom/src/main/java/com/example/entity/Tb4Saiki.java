package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 再帰
 * @author emarfkrow
 */
public class Tb4Saiki implements IEntity {

    /** SlickGridのDataView用ID */
    @jp.co.golorp.emarf.validation.GridViewRowId
    private Integer id;

    /** @return id */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id", index = 1)
    public final Integer getId() {
        return id;
    }

    /** @param o id */
    public final void setId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.id = Integer.valueOf(o.toString());
        } else {
            this.id = null;
        }
    }

    /** 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer saikiId;

    /** @return 再帰ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAIKI_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getSaikiId() {
        return this.saikiId;
    }

    /** @param o 再帰ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setSaikiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.saikiId = Integer.valueOf(o.toString());
        } else {
            this.saikiId = null;
        }
    }

    /** 再帰名 */
    private String saikiMei;

    /** @return 再帰名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "SAIKI_MEI", index = 3)
    public String getSaikiMei() {
        return this.saikiMei;
    }

    /** @param o 再帰名 */
    public void setSaikiMei(final Object o) {
        if (o != null) {
            this.saikiMei = o.toString();
        } else {
            this.saikiMei = null;
        }
    }

    /** 参照ID */
    private Integer refId;

    /** @return 参照ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_ID", index = 4)
    public Integer getRefId() {
        return this.refId;
    }

    /** @param o 参照ID */
    public void setRefId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.refId = Integer.valueOf(o.toString());
        } else {
            this.refId = null;
        }
    }

    /** 参照ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String refMei;

    /** @return 参照ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_MEI", index = 5)
    public String getRefMei() {
        return this.refMei;
    }

    /** @param o 参照ID参照 */
    public void setRefMei(final Object o) {
        if (o != null) {
            this.refMei = o.toString();
        } else {
            this.refMei = null;
        }
    }

    /** 参照CD */
    private String refCd;

    /** @return 参照CD */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_CD", index = 6)
    public String getRefCd() {
        return this.refCd;
    }

    /** @param o 参照CD */
    public void setRefCd(final Object o) {
        if (o != null) {
            this.refCd = o.toString();
        } else {
            this.refCd = null;
        }
    }

    /** 参照CD参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String refMei;

    /** @return 参照CD参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_MEI", index = 7)
    public String getRefMei() {
        return this.refMei;
    }

    /** @param o 参照CD参照 */
    public void setRefMei(final Object o) {
        if (o != null) {
            this.refMei = o.toString();
        } else {
            this.refMei = null;
        }
    }

    /** 参照NO */
    private String refNo;

    /** @return 参照NO */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_NO", index = 8)
    public String getRefNo() {
        return this.refNo;
    }

    /** @param o 参照NO */
    public void setRefNo(final Object o) {
        if (o != null) {
            this.refNo = o.toString();
        } else {
            this.refNo = null;
        }
    }

    /** 参照NO参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String refMei;

    /** @return 参照NO参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_MEI", index = 9)
    public String getRefMei() {
        return this.refMei;
    }

    /** @param o 参照NO参照 */
    public void setRefMei(final Object o) {
        if (o != null) {
            this.refMei = o.toString();
        } else {
            this.refMei = null;
        }
    }

    /** 参照連番 */
    private Integer refBn;

    /** @return 参照連番 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_BN", index = 10)
    public Integer getRefBn() {
        return this.refBn;
    }

    /** @param o 参照連番 */
    public void setRefBn(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.refBn = Integer.valueOf(o.toString());
        } else {
            this.refBn = null;
        }
    }

    /** 別参照ID */
    private Integer exRefId;

    /** @return 別参照ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_REF_ID", index = 11)
    public Integer getExRefId() {
        return this.exRefId;
    }

    /** @param o 別参照ID */
    public void setExRefId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.exRefId = Integer.valueOf(o.toString());
        } else {
            this.exRefId = null;
        }
    }

    /** 別参照ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String exRefMei;

    /** @return 別参照ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_REF_MEI", index = 12)
    public String getExRefMei() {
        return this.exRefMei;
    }

    /** @param o 別参照ID参照 */
    public void setExRefMei(final Object o) {
        if (o != null) {
            this.exRefMei = o.toString();
        } else {
            this.exRefMei = null;
        }
    }

    /** 別参照連番 */
    private Integer exRefBn;

    /** @return 別参照連番 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "EX_REF_BN", index = 13)
    public Integer getExRefBn() {
        return this.exRefBn;
    }

    /** @param o 別参照連番 */
    public void setExRefBn(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.exRefBn = Integer.valueOf(o.toString());
        } else {
            this.exRefBn = null;
        }
    }

    /** 親再帰ID */
    private Integer oyaSaikiId;

    /** @return 親再帰ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_SAIKI_ID", index = 14)
    public Integer getOyaSaikiId() {
        return this.oyaSaikiId;
    }

    /** @param o 親再帰ID */
    public void setOyaSaikiId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaSaikiId = Integer.valueOf(o.toString());
        } else {
            this.oyaSaikiId = null;
        }
    }

    /** 親再帰ID参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String oyaSaikiMei;

    /** @return 親再帰ID参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_SAIKI_MEI", index = 15)
    public String getOyaSaikiMei() {
        return this.oyaSaikiMei;
    }

    /** @param o 親再帰ID参照 */
    public void setOyaSaikiMei(final Object o) {
        if (o != null) {
            this.oyaSaikiMei = o.toString();
        } else {
            this.oyaSaikiMei = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 16)
    public java.time.LocalDateTime getInsertTs() {
        return this.insertTs;
    }

    /** @param o 作成タイムスタンプ */
    public void setInsertTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.insertTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.insertTs = null;
        }
    }

    /** 作成者 */
    private Integer insertUserId;

    /** @return 作成者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 17)
    public Integer getInsertUserId() {
        return this.insertUserId;
    }

    /** @param o 作成者 */
    public void setInsertUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.insertUserId = Integer.valueOf(o.toString());
        } else {
            this.insertUserId = null;
        }
    }

    /** 作成者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String insertUserSei;

    /** @return 作成者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 18)
    public String getInsertUserSei() {
        return this.insertUserSei;
    }

    /** @param o 作成者参照 */
    public void setInsertUserSei(final Object o) {
        if (o != null) {
            this.insertUserSei = o.toString();
        } else {
            this.insertUserSei = null;
        }
    }

    /** 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    @jp.co.golorp.emarf.validation.OptLock
    private java.time.LocalDateTime updateTs;

    /** @return 更新タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 19)
    @jp.co.golorp.emarf.validation.OptLock
    public java.time.LocalDateTime getUpdateTs() {
        return this.updateTs;
    }

    /** @param o 更新タイムスタンプ */
    @jp.co.golorp.emarf.validation.OptLock
    public void setUpdateTs(final Object o) {
        if (o != null && o instanceof Long) {
            java.util.Date d = new java.util.Date((Long) o);
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (o != null && o.toString().matches("^[0-9]+")) {
            java.util.Date d = new java.util.Date(Long.valueOf(o.toString()));
            this.updateTs = java.time.LocalDateTime.ofInstant(d.toInstant(), java.time.ZoneId.systemDefault());
        } else if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateTs = java.time.LocalDateTime.parse(o.toString().replace(" ", "T").replace("/", "-"));
        } else {
            this.updateTs = null;
        }
    }

    /** 更新者 */
    private Integer updateUserId;

    /** @return 更新者 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 20)
    public Integer getUpdateUserId() {
        return this.updateUserId;
    }

    /** @param o 更新者 */
    public void setUpdateUserId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.updateUserId = Integer.valueOf(o.toString());
        } else {
            this.updateUserId = null;
        }
    }

    /** 更新者参照 */
    @jp.co.golorp.emarf.validation.ReferMei
    private String updateUserSei;

    /** @return 更新者参照 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 21)
    public String getUpdateUserSei() {
        return this.updateUserSei;
    }

    /** @param o 更新者参照 */
    public void setUpdateUserSei(final Object o) {
        if (o != null) {
            this.updateUserSei = o.toString();
        } else {
            this.updateUserSei = null;
        }
    }

    /**
     * 再帰照会
     * @param param1 再帰ID
     * @return 再帰
     */
    public static Tb4Saiki get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`SAIKI_ID` = :saiki_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`SAIKI_ID` \n";
        sql += "    , a.`SAIKI_MEI` \n";
        sql += "    , a.`REF_ID` \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`REF_CD`) AS REF_CD \n";
        sql += "    , TRIM(TRAILING ' ' FROM a.`REF_NO`) AS REF_NO \n";
        sql += "    , a.`REF_BN` \n";
        sql += "    , a.`EX_REF_ID` \n";
        sql += "    , a.`EX_REF_BN` \n";
        sql += "    , a.`OYA_SAIKI_ID` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB4_SAIKI a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("saiki_id", param1);
        return Queries.get(sql, map, Tb4Saiki.class);
    }

    /**
     * 再帰追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 再帰IDの採番処理
        numbering();

        // 再帰の登録
        String sql = "INSERT INTO TB4_SAIKI(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`SAIKI_ID` -- :saiki_id");
        nameList.add("`SAIKI_MEI` -- :saiki_mei");
        nameList.add("`REF_ID` -- :ref_id");
        nameList.add("`REF_CD` -- :ref_cd");
        nameList.add("`REF_NO` -- :ref_no");
        nameList.add("`REF_BN` -- :ref_bn");
        nameList.add("`EX_REF_ID` -- :ex_ref_id");
        nameList.add("`EX_REF_BN` -- :ex_ref_bn");
        nameList.add("`OYA_SAIKI_ID` -- :oya_saiki_id");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":saiki_id");
        valueList.add(":saiki_mei");
        valueList.add(":ref_id");
        valueList.add(":ref_cd");
        valueList.add(":ref_no");
        valueList.add(":ref_bn");
        valueList.add(":ex_ref_id");
        valueList.add(":ex_ref_bn");
        valueList.add(":oya_saiki_id");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 再帰IDの採番処理 */
    private void numbering() {
        if (this.saikiId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`SAIKI_ID`) IS NULL THEN 0 ELSE MAX(e.`SAIKI_ID`) * 1 END + 1 AS `SAIKI_ID` FROM TB4_SAIKI e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("SAIKI_ID");
        this.setSaikiId(o);
    }

    /**
     * 再帰更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 再帰の登録
        String sql = "UPDATE TB4_SAIKI\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`SAIKI_ID` = :saiki_id");
        setList.add("`SAIKI_MEI` = :saiki_mei");
        setList.add("`REF_ID` = :ref_id");
        setList.add("`REF_CD` = :ref_cd");
        setList.add("`REF_NO` = :ref_no");
        setList.add("`REF_BN` = :ref_bn");
        setList.add("`EX_REF_ID` = :ex_ref_id");
        setList.add("`EX_REF_BN` = :ex_ref_bn");
        setList.add("`OYA_SAIKI_ID` = :oya_saiki_id");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 再帰削除
     * @return 削除件数
     */
    public int delete() {

        // 再帰の削除
        String sql = "DELETE FROM TB4_SAIKI WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`SAIKI_ID` = :saiki_id");
        whereList.add("`update_ts` = '" + this.updateTs + "'");
        return String.join(" AND ", whereList);
    }

    /**
     * @param now システム日時
     * @param execId 実行ID
     * @return マップ化したエンティティ
     */
    private Map<String, Object> toMap(final LocalDateTime now, final String execId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("saiki_id", this.saikiId);
        map.put("saiki_mei", this.saikiMei);
        map.put("ref_id", this.refId);
        map.put("ref_cd", this.refCd);
        map.put("ref_no", this.refNo);
        map.put("ref_bn", this.refBn);
        map.put("ex_ref_id", this.exRefId);
        map.put("ex_ref_bn", this.exRefBn);
        map.put("oya_saiki_id", this.oyaSaikiId);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }
}
