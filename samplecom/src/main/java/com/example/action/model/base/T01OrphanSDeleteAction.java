package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T01Orphan;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 孤児一覧削除
 *
 * @author emarfkrow
 */
public class T01OrphanSDeleteAction extends BaseAction {

    /** 孤児一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T01OrphanGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("OYA_ID"))) {
                    throw new OptLockError("error.cant.delete", "孤児");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("KO_BN"))) {
                    throw new OptLockError("error.cant.delete", "孤児");
                }

                T01Orphan e = FormValidator.toBean(T01Orphan.class.getName(), row);

                // child:T01Mago, parents:2

                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "孤児");
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
