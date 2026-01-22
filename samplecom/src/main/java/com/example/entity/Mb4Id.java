package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * IDマスタ
 * @author emarfkrow
 */
public class Mb4Id implements IEntity {

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

    /** 参照ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer refId;

    /** @return 参照ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getRefId() {
        return this.refId;
    }

    /** @param o 参照ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setRefId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.refId = Integer.valueOf(o.toString());
        } else {
            this.refId = null;
        }
    }

    /** 参照名 */
    private String refMei;

    /** @return 参照名 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "REF_MEI", index = 3)
    public String getRefMei() {
        return this.refMei;
    }

    /** @param o 参照名 */
    public void setRefMei(final Object o) {
        if (o != null) {
            this.refMei = o.toString();
        } else {
            this.refMei = null;
        }
    }

    /** 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class)
    private java.time.LocalDateTime insertTs;

    /** @return 作成タイムスタンプ */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_TS", index = 4)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_ID", index = 5)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "INSERT_USER_SEI", index = 6)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_TS", index = 7)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_ID", index = 8)
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
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UPDATE_USER_SEI", index = 9)
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
     * IDマスタ照会
     * @param param1 参照ID
     * @return IDマスタ
     */
    public static Mb4Id get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`REF_ID` = :ref_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`REF_ID` \n";
        sql += "    , a.`REF_MEI` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    MB4_ID a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ref_id", param1);
        return Queries.get(sql, map, Mb4Id.class);
    }

    /**
     * IDマスタ追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 参照IDの採番処理
        numbering();

        // ID連番マスタの登録
        if (this.mb4Idbns != null) {
            for (Mb4Idbn mb4Idbn : this.mb4Idbns) {
                if (mb4Idbn != null) {
                    mb4Idbn.setRefId(this.getRefId());
                }
                mb4Idbn.insert(now, execId);
            }
        }

        // IDマスタの登録
        String sql = "INSERT INTO MB4_ID(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`REF_ID` -- :ref_id");
        nameList.add("`REF_MEI` -- :ref_mei");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":ref_id");
        valueList.add(":ref_mei");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 参照IDの採番処理 */
    private void numbering() {
        if (this.refId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`REF_ID`) IS NULL THEN 0 ELSE MAX(e.`REF_ID`) * 1 END + 1 AS `REF_ID` FROM MB4_ID e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("REF_ID");
        this.setRefId(o);
    }

    /**
     * IDマスタ更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // ID連番マスタの登録
        if (this.mb4Idbns != null) {
            for (Mb4Idbn mb4Idbn : this.mb4Idbns) {
                if (mb4Idbn == null) {
                    continue;
                }
                mb4Idbn.setRefId(this.refId);
                try {
                    mb4Idbn.insert(now, execId);
                } catch (Exception e) {
                    mb4Idbn.update(now, execId);
                }
            }
        }

        // IDマスタの登録
        String sql = "UPDATE MB4_ID\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`REF_ID` = :ref_id");
        setList.add("`REF_MEI` = :ref_mei");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * IDマスタ削除
     * @return 削除件数
     */
    public int delete() {

        // ID連番マスタの削除
        if (this.mb4Idbns != null) {
            for (Mb4Idbn mb4Idbn : this.mb4Idbns) {
                if (mb4Idbn.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "ID連番マスタ");
                }
            }
        }

        // IDマスタの削除
        String sql = "DELETE FROM MB4_ID WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`REF_ID` = :ref_id");
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
        map.put("ref_id", this.refId);
        map.put("ref_mei", this.refMei);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：ID連番マスタ
     */

    /** ID連番マスタのリスト */
    private List<Mb4Idbn> mb4Idbns;

    /** @return ID連番マスタのリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Mb4Idbns", index = 10)
    public List<Mb4Idbn> getMb4Idbns() {
        return this.mb4Idbns;
    }

    /** @param list ID連番マスタのリスト */
    public void setMb4Idbns(final List<Mb4Idbn> list) {
        this.mb4Idbns = list;
    }

    /** @param mb4Idbn */
    public void addMb4Idbns(final Mb4Idbn mb4Idbn) {
        if (this.mb4Idbns == null) {
            this.mb4Idbns = new ArrayList<Mb4Idbn>();
        }
        this.mb4Idbns.add(mb4Idbn);
    }

    /** @return ID連番マスタのリスト */
    public List<Mb4Idbn> referMb4Idbns() {
        this.mb4Idbns = Mb4Id.referMb4Idbns(this.refId);
        return this.mb4Idbns;
    }

    /**
     * @param param1 refId
     * @return List<Mb4Idbn>
     */
    public static List<Mb4Idbn> referMb4Idbns(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("REF_ID = :ref_id");
        String sql = "SELECT ";
        sql += "`REF_ID`";
        sql += ", `REF_BN`";
        sql += ", `IDBN_NO`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM MB4_IDBN a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "REF_ID, REF_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ref_id", param1);
        List<Mb4Idbn> list = Queries.select(sql, map, Mb4Idbn.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Mb4Idbn>();
    }
}
