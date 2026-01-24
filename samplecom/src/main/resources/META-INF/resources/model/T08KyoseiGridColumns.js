/**
 * 共生グリッド定義
 */

let T08KyoseiGridColumns = [];

$(function() {
    T08KyoseiGridColumns = [
        Column.text('KYOSEI_ID', Messages['T08KyoseiGrid.kyoseiId'], 90, 'primaryKey numbering', null),
        Column.refer('KISEI1_ID', Messages['T08KyoseiGrid.kisei1Id'], 90, 'notblank', ''),
        Column.text('KISEI1_INFO', Messages['T08KyoseiGrid.kisei1Info'], 300, '', null),
        Column.refer('KISEI2_ID', Messages['T08KyoseiGrid.kisei2Id'], 90, 'notblank', ''),
        Column.text('KISEI2_INFO', Messages['T08KyoseiGrid.kisei2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T08KyoseiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
