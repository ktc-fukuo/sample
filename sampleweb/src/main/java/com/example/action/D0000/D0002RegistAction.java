package com.example.action.D0000;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Ko;
import com.example.entity.T01Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.AppError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 詳細画面登録アクション
 * @author toshiyuki
 *
 */
public class D0002RegistAction extends BaseAction {

    /**
     *
     */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String id, final Map<String, Object> postJson) {

        T01Ko tKo = FormValidator.toBean(T01Ko.class.getName(), postJson);

        //        TEntity2 tEntity2 = FormValidator.toBean(TEntity2.class.getName(), postJson);
        //        tEntity.setTEntity2(tEntity2);

        T01Oya tOya = FormValidator.toBean(T01Oya.class.getName(), postJson);
        tOya.addT01Kos(tKo);

        if (tOya.insert(now, id) != 1) {
            throw new AppError("error.cant.insert");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.insert"));
        return map;
    }

}
