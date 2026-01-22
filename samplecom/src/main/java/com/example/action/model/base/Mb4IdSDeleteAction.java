package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.Mb4Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * IDマスタ一覧削除
 *
 * @author emarfkrow
 */
public class Mb4IdSDeleteAction extends BaseAction {

    /** IDマスタ一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("Mb4IdGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("REF_ID"))) {
                    throw new OptLockError("error.cant.delete", "IDマスタ");
                }

                Mb4Id e = FormValidator.toBean(Mb4Id.class.getName(), row);

                java.util.List<com.example.entity.Mb4Idbn> mb4Idbns = e.referMb4Idbns();
                if (mb4Idbns != null) {
                    for (com.example.entity.Mb4Idbn mb4Idbn : mb4Idbns) {

                        if (mb4Idbn.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "ID連番マスタ");
                        }
                    }
                }

                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "IDマスタ");
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
