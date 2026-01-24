package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.V13Henkan;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * VIEW一覧登録
 *
 * @author emarfkrow
 */
public class V13HenkanSRegistAction extends BaseAction {

    /** VIEW一覧登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("V13HenkanGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                V13Henkan e = FormValidator.toBean(V13Henkan.class.getName(), row);

                // 主キーが不足していたらINSERT
                boolean isNew = false;

                if (isNew) {

                    if (e.insert(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "VIEW");
                    }
                    ++count;

                } else {

                    if (e.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.update", "VIEW");
                    }
                    ++count;
                }
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.regist"));
        return map;
    }

}
