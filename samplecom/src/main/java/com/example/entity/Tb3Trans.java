package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 変遷
 * @author emarfkrow
 */
public class Tb3Trans implements IEntity {

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

    /** 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer transId;

    /** @return 変遷ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TRANS_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getTransId() {
        return this.transId;
    }

    /** @param o 変遷ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setTransId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.transId = Integer.valueOf(o.toString());
        } else {
            this.transId = null;
        }
    }

    /** 変遷情報 */
    private String transInfo;

    /** @return 変遷情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "TRANS_INFO", index = 3)
    public String getTransInfo() {
        return this.transInfo;
    }

    /** @param o 変遷情報 */
    public void setTransInfo(final Object o) {
        if (o != null) {
            this.transInfo = o.toString();
        } else {
            this.transInfo = null;
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
     * 変遷照会
     * @param param1 変遷ID
     * @return 変遷
     */
    public static Tb3Trans get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`TRANS_ID` = :trans_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`TRANS_ID` \n";
        sql += "    , a.`TRANS_INFO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB3_TRANS a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("trans_id", param1);
        return Queries.get(sql, map, Tb3Trans.class);
    }

    /**
     * 変遷追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 変遷IDの採番処理
        numbering();

        // 変遷履歴の登録
        if (this.tb3TransHiss != null) {
            for (Tb3TransHis tb3TransHis : this.tb3TransHiss) {
                if (tb3TransHis != null) {
                    tb3TransHis.setTransId(this.getTransId());
                }
                tb3TransHis.insert(now, execId);
            }
        }

        // 変遷の登録
        String sql = "INSERT INTO TB3_TRANS(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`TRANS_ID` -- :trans_id");
        nameList.add("`TRANS_INFO` -- :trans_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":trans_id");
        valueList.add(":trans_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 変遷IDの採番処理 */
    private void numbering() {
        if (this.transId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`TRANS_ID`) IS NULL THEN 0 ELSE MAX(e.`TRANS_ID`) * 1 END + 1 AS `TRANS_ID` FROM TB3_TRANS e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("TRANS_ID");
        this.setTransId(o);
    }

    /**
     * 変遷更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 変遷履歴の登録
        if (this.tb3TransHiss != null) {
            for (Tb3TransHis tb3TransHis : this.tb3TransHiss) {
                if (tb3TransHis == null) {
                    continue;
                }
                tb3TransHis.setTransId(this.transId);
                try {
                    tb3TransHis.insert(now, execId);
                } catch (Exception e) {
                    tb3TransHis.update(now, execId);
                }
            }
        }

        // 変遷の登録
        String sql = "UPDATE TB3_TRANS\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`TRANS_ID` = :trans_id");
        setList.add("`TRANS_INFO` = :trans_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 変遷削除
     * @return 削除件数
     */
    public int delete() {

        // 変遷履歴の削除
        if (this.tb3TransHiss != null) {
            for (Tb3TransHis tb3TransHis : this.tb3TransHiss) {
                if (tb3TransHis.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "変遷履歴");
                }
            }
        }

        // 変遷の削除
        String sql = "DELETE FROM TB3_TRANS WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`TRANS_ID` = :trans_id");
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
        map.put("trans_id", this.transId);
        map.put("trans_info", this.transInfo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：変遷履歴
     */

    /** 変遷履歴のリスト */
    private List<Tb3TransHis> tb3TransHiss;

    /** @return 変遷履歴のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb3TransHiss", index = 10)
    public List<Tb3TransHis> getTb3TransHiss() {
        return this.tb3TransHiss;
    }

    /** @param list 変遷履歴のリスト */
    public void setTb3TransHiss(final List<Tb3TransHis> list) {
        this.tb3TransHiss = list;
    }

    /** @param tb3TransHis */
    public void addTb3TransHiss(final Tb3TransHis tb3TransHis) {
        if (this.tb3TransHiss == null) {
            this.tb3TransHiss = new ArrayList<Tb3TransHis>();
        }
        this.tb3TransHiss.add(tb3TransHis);
    }

    /** @return 変遷履歴のリスト */
    public List<Tb3TransHis> referTb3TransHiss() {
        this.tb3TransHiss = Tb3Trans.referTb3TransHiss(this.transId);
        return this.tb3TransHiss;
    }

    /**
     * @param param1 transId
     * @return List<Tb3TransHis>
     */
    public static List<Tb3TransHis> referTb3TransHiss(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("TRANS_ID = :trans_id");
        String sql = "SELECT ";
        sql += "`TRANS_ID`";
        sql += ", `TRANS_BN`";
        sql += ", `TRANS_INFO`";
        sql += ", `RIYU_TX`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB3_TRANS_HIS a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "TRANS_ID, TRANS_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("trans_id", param1);
        List<Tb3TransHis> list = Queries.select(sql, map, Tb3TransHis.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb3TransHis>();
    }
}
