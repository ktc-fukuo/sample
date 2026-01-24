package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T01Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 親一覧削除
 *
 * @author emarfkrow
 */
public class T01OyaSDeleteAction extends BaseAction {

    /** 親一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T01OyaGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("OYA_ID"))) {
                    throw new OptLockError("error.cant.delete", "親");
                }

                T01Oya e = FormValidator.toBean(T01Oya.class.getName(), row);

                java.util.List<com.example.entity.T01Dinks> t01Dinkss = e.referT01Dinkss();
                if (t01Dinkss != null) {
                    for (com.example.entity.T01Dinks t01Dinks : t01Dinkss) {

                        if (t01Dinks.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "子なし");
                        }
                    }
                }


                java.util.List<com.example.entity.T01Ko> t01Kos = e.referT01Kos();
                if (t01Kos != null) {
                    for (com.example.entity.T01Ko t01Ko : t01Kos) {

                        // child:T01Mago, parents:2


                        if (t01Ko.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "子");
                        }
                    }
                }


                java.util.List<com.example.entity.T01Orphan> t01Orphans = e.referT01Orphans();
                if (t01Orphans != null) {
                    for (com.example.entity.T01Orphan t01Orphan : t01Orphans) {

                        // child:T01Mago, parents:2


                        if (t01Orphan.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "孤児");
                        }
                    }
                }

                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "親");
                }
                ++count;
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
