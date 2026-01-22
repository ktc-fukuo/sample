package com.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.golorp.emarf.entity.IEntity;
import jp.co.golorp.emarf.sql.Queries;

/**
 * 親
 * @author emarfkrow
 */
public class Tb1Oya implements IEntity {

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

    /** 親ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    private Integer oyaId;

    /** @return 親ID */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_ID", index = 2)
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public Integer getOyaId() {
        return this.oyaId;
    }

    /** @param o 親ID */
    @jp.co.golorp.emarf.validation.PrimaryKeys
    public void setOyaId(final Object o) {
        if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(o)) {
            this.oyaId = Integer.valueOf(o.toString());
        } else {
            this.oyaId = null;
        }
    }

    /** 親情報 */
    private String oyaInfo;

    /** @return 親情報 */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "OYA_INFO", index = 3)
    public String getOyaInfo() {
        return this.oyaInfo;
    }

    /** @param o 親情報 */
    public void setOyaInfo(final Object o) {
        if (o != null) {
            this.oyaInfo = o.toString();
        } else {
            this.oyaInfo = null;
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
     * 親照会
     * @param param1 親ID
     * @return 親
     */
    public static Tb1Oya get(final Object param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`OYA_ID` = :oya_id");
        String sql = "";
        sql += "SELECT \n";
        sql += "      a.`OYA_ID` \n";
        sql += "    , a.`OYA_INFO` \n";
        sql += "    , a.`INSERT_TS` AS INSERT_TS \n";
        sql += "    , a.`INSERT_USER_ID` \n";
        sql += "    , a.`UPDATE_TS` AS UPDATE_TS \n";
        sql += "    , a.`UPDATE_USER_ID` \n";
        sql += "FROM \n";
        sql += "    TB1_OYA a \n";
        sql += "WHERE \n";
        sql += String.join(" AND \n", whereList);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oya_id", param1);
        return Queries.get(sql, map, Tb1Oya.class);
    }

    /**
     * 親追加
     * @param now システム日時
     * @param execId 登録者
     * @return 追加件数
     */
    public int insert(final LocalDateTime now, final String execId) {

        // 親IDの採番処理
        numbering();

        // 子なしの登録
        if (this.tb1Dinkss != null) {
            for (Tb1Dinks tb1Dinks : this.tb1Dinkss) {
                if (tb1Dinks != null) {
                    tb1Dinks.setOyaId(this.getOyaId());
                }
                tb1Dinks.insert(now, execId);
            }
        }

        // 子の登録
        if (this.tb1Kos != null) {
            for (Tb1Ko tb1Ko : this.tb1Kos) {
                if (tb1Ko != null) {
                    tb1Ko.setOyaId(this.getOyaId());
                }
                tb1Ko.insert(now, execId);
            }
        }

        // 孤児の登録
        if (this.tb1Orphans != null) {
            for (Tb1Orphan tb1Orphan : this.tb1Orphans) {
                if (tb1Orphan != null) {
                    tb1Orphan.setOyaId(this.getOyaId());
                }
                tb1Orphan.insert(now, execId);
            }
        }

        // 親の登録
        String sql = "INSERT INTO TB1_OYA(\r\n      " + names() + "\r\n) VALUES (\r\n      " + values() + "\r\n)";
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return insert用のname句 */
    private String names() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("`OYA_ID` -- :oya_id");
        nameList.add("`OYA_INFO` -- :oya_info");
        nameList.add("`INSERT_TS` -- :insert_ts");
        nameList.add("`INSERT_USER_ID` -- :insert_user_id");
        nameList.add("`UPDATE_TS` -- :update_ts");
        nameList.add("`UPDATE_USER_ID` -- :update_user_id");
        return String.join("\r\n    , ", nameList);
    }

    /** @return insert用のvalue句 */
    private String values() {
        List<String> valueList = new ArrayList<String>();
        valueList.add(":oya_id");
        valueList.add(":oya_info");
        valueList.add(":insert_ts");
        valueList.add(":insert_user_id");
        valueList.add(":update_ts");
        valueList.add(":update_user_id");
        return String.join("\r\n    , ", valueList);
    }

    /** 親IDの採番処理 */
    private void numbering() {
        if (this.oyaId != null) {
            return;
        }
        String sql = "SELECT CASE WHEN MAX(e.`OYA_ID`) IS NULL THEN 0 ELSE MAX(e.`OYA_ID`) * 1 END + 1 AS `OYA_ID` FROM TB1_OYA e";
        Map<String, Object> map = new HashMap<String, Object>();
        jp.co.golorp.emarf.util.MapList mapList = Queries.select(sql, map, null, null);
        Object o = mapList.get(0).get("OYA_ID");
        this.setOyaId(o);
    }

    /**
     * 親更新
     * @param now システム日時
     * @param execId 更新者
     * @return 更新件数
     */
    public int update(final LocalDateTime now, final String execId) {

        // 子なしの登録
        if (this.tb1Dinkss != null) {
            for (Tb1Dinks tb1Dinks : this.tb1Dinkss) {
                if (tb1Dinks == null) {
                    continue;
                }
                tb1Dinks.setOyaId(this.oyaId);
                try {
                    tb1Dinks.insert(now, execId);
                } catch (Exception e) {
                    tb1Dinks.update(now, execId);
                }
            }
        }

        // 子の登録
        if (this.tb1Kos != null) {
            for (Tb1Ko tb1Ko : this.tb1Kos) {
                if (tb1Ko == null) {
                    continue;
                }
                tb1Ko.setOyaId(this.oyaId);
                try {
                    tb1Ko.insert(now, execId);
                } catch (Exception e) {
                    tb1Ko.update(now, execId);
                }
            }
        }

        // 孤児の登録
        if (this.tb1Orphans != null) {
            for (Tb1Orphan tb1Orphan : this.tb1Orphans) {
                if (tb1Orphan == null) {
                    continue;
                }
                tb1Orphan.setOyaId(this.oyaId);
                try {
                    tb1Orphan.insert(now, execId);
                } catch (Exception e) {
                    tb1Orphan.update(now, execId);
                }
            }
        }

        // 親の登録
        String sql = "UPDATE TB1_OYA\r\nSET\r\n      " + getSet() + "\r\nWHERE\r\n    " + getWhere();
        return Queries.regist(sql, toMap(now, execId));
    }

    /** @return update用のset句 */
    private String getSet() {
        List<String> setList = new ArrayList<String>();
        setList.add("`OYA_ID` = :oya_id");
        setList.add("`OYA_INFO` = :oya_info");
        setList.add("`UPDATE_TS` = :update_ts");
        setList.add("`UPDATE_USER_ID` = :update_user_id");
        return String.join("\r\n    , ", setList);
    }

    /**
     * 親削除
     * @return 削除件数
     */
    public int delete() {

        // 子なしの削除
        if (this.tb1Dinkss != null) {
            for (Tb1Dinks tb1Dinks : this.tb1Dinkss) {
                if (tb1Dinks.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "子なし");
                }
            }
        }

        // 子の削除
        if (this.tb1Kos != null) {
            for (Tb1Ko tb1Ko : this.tb1Kos) {
                if (tb1Ko.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "子");
                }
            }
        }

        // 孤児の削除
        if (this.tb1Orphans != null) {
            for (Tb1Orphan tb1Orphan : this.tb1Orphans) {
                if (tb1Orphan.delete() != 1) {
                    throw new jp.co.golorp.emarf.exception.OptLockError("error.cant.delete", "孤児");
                }
            }
        }

        // 親の削除
        String sql = "DELETE FROM TB1_OYA WHERE " + getWhere();
        return Queries.regist(sql, toMap(null, null));
    }

    /** @return where句 */
    private String getWhere() {
        List<String> whereList = new ArrayList<String>();
        whereList.add("`OYA_ID` = :oya_id");
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
        map.put("oya_id", this.oyaId);
        map.put("oya_info", this.oyaInfo);
        map.put("insert_ts", now);
        map.put("insert_user_id", execId);
        map.put("update_ts", now);
        map.put("update_user_id", execId);
        return map;
    }

    /*
     * 子モデル：子なし
     */

    /** 子なしのリスト */
    private List<Tb1Dinks> tb1Dinkss;

    /** @return 子なしのリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb1Dinkss", index = 10)
    public List<Tb1Dinks> getTb1Dinkss() {
        return this.tb1Dinkss;
    }

    /** @param list 子なしのリスト */
    public void setTb1Dinkss(final List<Tb1Dinks> list) {
        this.tb1Dinkss = list;
    }

    /** @param tb1Dinks */
    public void addTb1Dinkss(final Tb1Dinks tb1Dinks) {
        if (this.tb1Dinkss == null) {
            this.tb1Dinkss = new ArrayList<Tb1Dinks>();
        }
        this.tb1Dinkss.add(tb1Dinks);
    }

    /** @return 子なしのリスト */
    public List<Tb1Dinks> referTb1Dinkss() {
        this.tb1Dinkss = Tb1Oya.referTb1Dinkss(this.oyaId);
        return this.tb1Dinkss;
    }

    /**
     * @param param1 oyaId
     * @return List<Tb1Dinks>
     */
    public static List<Tb1Dinks> referTb1Dinkss(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("OYA_ID = :oya_id");
        String sql = "SELECT ";
        sql += "`OYA_ID`";
        sql += ", `KO_BN`";
        sql += ", `DINKS_INFO`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB1_DINKS a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "OYA_ID, KO_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oya_id", param1);
        List<Tb1Dinks> list = Queries.select(sql, map, Tb1Dinks.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb1Dinks>();
    }

    /*
     * 子モデル：子
     */

    /** 子のリスト */
    private List<Tb1Ko> tb1Kos;

    /** @return 子のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb1Kos", index = 11)
    public List<Tb1Ko> getTb1Kos() {
        return this.tb1Kos;
    }

    /** @param list 子のリスト */
    public void setTb1Kos(final List<Tb1Ko> list) {
        this.tb1Kos = list;
    }

    /** @param tb1Ko */
    public void addTb1Kos(final Tb1Ko tb1Ko) {
        if (this.tb1Kos == null) {
            this.tb1Kos = new ArrayList<Tb1Ko>();
        }
        this.tb1Kos.add(tb1Ko);
    }

    /** @return 子のリスト */
    public List<Tb1Ko> referTb1Kos() {
        this.tb1Kos = Tb1Oya.referTb1Kos(this.oyaId);
        return this.tb1Kos;
    }

    /**
     * @param param1 oyaId
     * @return List<Tb1Ko>
     */
    public static List<Tb1Ko> referTb1Kos(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("OYA_ID = :oya_id");
        String sql = "SELECT ";
        sql += "`OYA_ID`";
        sql += ", `KO_BN`";
        sql += ", `KO_INFO`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB1_KO a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "OYA_ID, KO_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oya_id", param1);
        List<Tb1Ko> list = Queries.select(sql, map, Tb1Ko.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb1Ko>();
    }

    /*
     * 子モデル：孤児
     */

    /** 孤児のリスト */
    private List<Tb1Orphan> tb1Orphans;

    /** @return 孤児のリスト */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Tb1Orphans", index = 12)
    public List<Tb1Orphan> getTb1Orphans() {
        return this.tb1Orphans;
    }

    /** @param list 孤児のリスト */
    public void setTb1Orphans(final List<Tb1Orphan> list) {
        this.tb1Orphans = list;
    }

    /** @param tb1Orphan */
    public void addTb1Orphans(final Tb1Orphan tb1Orphan) {
        if (this.tb1Orphans == null) {
            this.tb1Orphans = new ArrayList<Tb1Orphan>();
        }
        this.tb1Orphans.add(tb1Orphan);
    }

    /** @return 孤児のリスト */
    public List<Tb1Orphan> referTb1Orphans() {
        this.tb1Orphans = Tb1Oya.referTb1Orphans(this.oyaId);
        return this.tb1Orphans;
    }

    /**
     * @param param1 oyaId
     * @return List<Tb1Orphan>
     */
    public static List<Tb1Orphan> referTb1Orphans(final Integer param1) {
        List<String> whereList = new ArrayList<String>();
        whereList.add("OYA_ID = :oya_id");
        String sql = "SELECT ";
        sql += "`OYA_ID`";
        sql += ", `KO_BN`";
        sql += ", `ORPHAN_INFO`";
        sql += ", `INSERT_TS` AS INSERT_TS";
        sql += ", `INSERT_USER_ID`";
        sql += ", (SELECT r0.`USER_SEI` FROM MHR_USER r0 WHERE r0.`USER_ID` = a.`INSERT_USER_ID`) AS `INSERT_USER_SEI`";
        sql += ", `UPDATE_TS` AS UPDATE_TS";
        sql += ", `UPDATE_USER_ID`";
        sql += ", (SELECT r1.`USER_SEI` FROM MHR_USER r1 WHERE r1.`USER_ID` = a.`UPDATE_USER_ID`) AS `UPDATE_USER_SEI`";
        sql += " FROM TB1_ORPHAN a WHERE " + String.join(" AND ", whereList);
        sql += " ORDER BY ";
        sql += "OYA_ID, KO_BN";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oya_id", param1);
        List<Tb1Orphan> list = Queries.select(sql, map, Tb1Orphan.class, null, null);
        if (list != null) {
            return list;
        }
        return new ArrayList<Tb1Orphan>();
    }
}
