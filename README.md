House.Uploader
=========

House.Uploader - загрузка технического охвата. Краткое описание элементов XSD схемы. Последняя версия схемы расположена здесь http://crm.ttk.ru/schema/uploader/ttk-uploader-1.2.xsd

<span style="color: red">ВАЖНО!</span>
> * Не забывайте о порядке следования тэгов в файле - валидация по схеме укажет, какой элемент расположен некорректно
> * Корректно пишите названия тэгов


Корневые элементы тэга uploader
----
```xml
    <!-- type всегда HOUSE -->
    <uploader type="HOUSE">
    
        <!-- дата создания -->
        <createdAt>2006-05-04T18:13:51.0</createdAt> 
        
        <!-- название подразделения, создавшего файл id и name - любые строковые знаяения -->        
        <division>
            <id>id0</id>
            <name>name0</name>
        </division>
        
        <!-- метрики по этому файлу - указываем количество домов в этом файле-->
        <metrics>
            <houses>0</houses>
        </metrics>
        <data>
        <!-- здесь собственно данные - описание ниже -->
        </data>
    </uploader
```


Описание элементов data
----

> Внутри тэга data один или более элементов addressObject(обязательный)

```xml
<!-- описание адресного объекта -->
<addressObject>
    <!-- необязательный - если знаем указываем ФИАС level -->
    <fiasLevel>0</fiasLevel>
    <!-- необязательный - если знаем указываем ФИАС UUID -->
    <fiasId>fiasUUID</fiasId>
    <!-- обязательный - тип адресного объекта берется из ФИАС, т.е. это улица, переулок, площадь и т.п. - для примера - regexp маска [а-яА-Я0-9. ,-]{1,} -->
    <type>проспект</type>
    <!-- обязательный - название улицы, переулка и т.п.-->
    <name>Ленина</name>
    <!-- обязательный - Полное название до типа объекта, т.е. если  -->
    <fullAddress>Ростовская область, город Ростов-на-Дону, проспект Ленина</fullAddress>
        <!-- обязательный - от отдного и более - здесь все дома которые находятся по вышеуказанному адресу  -->
        <!-- внутри тэга houses могут быть, а могут и отсутствовать тэги house и housePrivate  -->
        <houses>
            <!-- внтури тэга houses могут отсутствовать тэги house - от отдного и более - здесь все дома которые находятся по вышеуказанному адресу  -->
            <!-- параметр id - любое текстовое значение, id дома в вашей системе, необходим для разрешения неоднозначных ситуаций при загрузке данных -->            
            <house id="id1">
                <!-- обязательный - тип дома - возможные значения APARTMENT(многоквартрный дом), BUSINESS(бизнес-центр или смешанный) -->
                <type>APARTMENT</type>
                <!-- обязательный - дата создания/заведения информации в вашей системе -->            
                <createdAt>2006-05-04T18:13:51.0</createdAt>
                <!-- дата готовности подключения к Сети, т.е. когда протянули -->            
                <readyDate>2006-05-04T18:13:51.0</readyDate>
                
                <!-- обязательный - метрика по многоквартирному дому - если знаете заполняете - иначе ставьте 0 -->            
                <measurements>
                    <!-- обязательный - количество подъездов -->            
                    <entrances>0</entrances>
                    <!-- обязательный - количество квартир -->            
                    <flats>0</flats>
                    <!-- обязательный - квартри на этаж - если есть такие данные -->            
                    <flatPerFloor>0</flatPerFloor>
                    <!-- обязательный - количество этажей -->            
                    <floors>0</floors>
                </measurements>
                <!-- доступные сервисы по дому -->            
                <services>
                    <!-- доступные интернет технологии - на данный момент значения могут быть FTTB, ADSL, PLC -->            
                    <internet>
                        <technology>FTTB</technology>
                    </internet>
                    <internet>
                        <technology>ADSL</technology>
                    </internet>
                    <!-- доступные ТВ технологии - на данный момент значения могут быть KTB, IPTV, DVB-C -->            
                    <tv>
                        <technology>KTB</technology>
                    </tv>
                    <!-- доступные телефонные технологии - на данный момент только BASIC -->            
                    <phone>
                        <technology>BASIC</technology>
                    </phone>
                </services>
                <!-- ФИАС UUID дома - если есть -->            
                <fiasId>fiasHouseUUID</fiasId>
                <!-- обязательный - номер дома -->            
                <number>20</number>
                <!-- корпус - если есть - например есть дом 18 корпус 2 строение 2 - сюда пишем 3 -->            
                <corpus>2</corpus>
                <!-- строение - если есть - для примера есть дом 18 корпус 2 строение 3 - сюда пишем 3 -->            
                <structure>3</structure>
                <!-- обязательный - полная строка так если есть дом 18 корпус 2 строение 2 - сюда пишем д.18 корп.2 стр.3 -->
                <integratedNumber>д.18 корп.2 стр.3</integratedNumber>
                <!-- почтовый индекс- если есть -->
                <postalCode>123456</postalCode>
                <!-- текстовый комментарий - если есть -->
                <comments>Текстовый комментарий к дому</comments>
                
                <!-- управляющая компания -->
                <managementCompany>
                <!-- описание ниже -->
                </managementCompany>
                
                <!-- Подъезды  -->
                <entrances count="0">
                <!-- описание ниже -->
                </entrances>
                
                <!-- информация по обходам -->
                <inspections>
                <!-- описание ниже -->
                </inspections>
                
                <!-- наличие распределенной сети -->
                <spreadNetwork>false</spreadNetwork>
            </house>
            
            <!-- частный дом - большинство параметров повторяют многоквартрный дом -->
            <housePrivate id="id5">
                <!-- обязательный у частного дома - всегда PRIVATE -->
                <type>PRIVATE</type>
                <createdAt>2006-05-04T18:13:51.0</createdAt>
                <readyDate>2006-05-04T18:13:51.0</readyDate>
                <services>
                    <internet>
                        <technology>FTTB</technology>
                    </internet>
                    <tv>
                        <technology>KTB</technology>
                    </tv>
                    <phone>
                        <technology>BASIC</technology>
                    </phone>
                </services>
                <number>number2</number>
                <integratedNumber>integratedNumber2</integratedNumber>
                <!-- Клиенты этого частного дома -->
                <clients>
                <!-- описание ниже -->
                </clients>
                <spreadNetwork>false</spreadNetwork>
            </housePrivate>
        </houses>
    </addressObject>
```


Тэг managementCompany 
----

```xml
    <!-- управляющая компания -->
    <managementCompany>
        <name>Краткое название</name>
        <fullName>Полное название компании</fullName>
        <address>
            <!-- обязательный - фактический адрес -->
            <factual />
            <!-- если есть - юридический -->
            <legal />
            <!-- если есть - подробный адрес с указанием почтового индекса и т.п. -->
            <composite>
                <index />
                <city />
                <street />
                <house />
                <appartment />
            </composite>
        </address>
        <!-- если есть - детали по управляющей компании -->
        <details>
            <inn />
            <kpp />
            <!-- Рассчетный счет -->
            <rs />
            <bank />
            <!-- Корр. счет -->
            <ks />
            <bik />
        </details>
        <!-- обязательный - контактные телефоны -->
        <phones>
            <cityphone />
            <mobphone />
        </phones>
        <!-- обязательный - -->
        <email>
            <primary />
            <secondary />
        </email>
        <!-- обязытельный - с кем можно коммуницировать в компании -->
        <communication>
            <!-- много элементов -->
            <element>
                <!-- обязытельный - ФИО -->
                <fio />
                <!-- обязытельный - контакты -->
                <managementContacts>
                    <managementContact type="PHONE">+71231234567</managementContact>
                    <managementContact type="EMAIL">test@test.net</managementContact>
                </managementContacts>
            </element>
        </communication>
        <!-- если есть - Менеджеры компании -->
        <managers>
            <element>
                <fio />
                <userId />
            </element>
        </managers>
    </managementCompany>
```


Тэг entrances 
----

```xml
    <!-- подъезды - для многоквартрных домов и бизнесцентров -->
    <!-- параметр count  сколько всего подъездов -->
    <entrances count="1">
        <!-- обязательный - от одного и более -->        
        <entrance number="number1">
            <!-- если есть - реклама -->
            <adverisements>
                <adverisement />
                <adverisement />
            </adverisements>
            <!-- если есть - комментарии к подъезду -->
            <comments />
            <!-- если есть - квартиры -->
            <units>
                <unit>
                    <!-- обязательный - номер квартиры -->
                    <number>number1</number>
                    <!-- обязательный - тип квартиры FLAT, OFFICE -->
                    <type>FLAT</type>
                    <!-- если есть - комментарии к квартире -->
                    <comments />
                    <!-- если есть - клиенты -->
                    <clients>
                        <client>
                            <!-- обязательный - id клиента в вашей системе -->
                            <cid>cid0</cid>
                            <!-- обязательный - Фамилия -->
                            <lastName>lastName0</lastName>
                            <!-- обязательный - Имя -->
                            <firstName>firstName0</firstName>
                            <!-- если есть - Отчество -->
                            <middleName />
                            <!-- если есть - дата рождения -->
                            <birthDate>1900-01-10</birthDate>
                            <!-- если есть - номер аккаунта в вашей системе -->
                            <accountNumber />
                            <!-- если есть - номер контракта в вашей системе -->
                            <contractNumber />
                            <!-- если есть - ФИО того кто создал в вашей системе -->
                            <createdBy />
                            <!-- если есть - ID того кто создал в вашей системе -->
                            <createdId />
                            <!-- если есть - когда создана запись в вашей системе -->
                            <createdAt>2006-05-04T18:13:51.0</createdAt>
                        </client>
                    </clients>
                </unit>
            </units>
        </entrance>
    </entrances>
```

Тэг inspections
----

```xml
<!-- обходы -->
<inspections>
    <!-- ноль или более обходов -->
    <inspection>
        <!-- номер квартиры если есть -->
        <unitNumber />
        <!-- обязательный - дата создания обхода -->
        <createdAt>2006-05-04T18:13:51.0</createdAt>
        <!-- если есть - текстовое поле ФИО -->        
        <createdBy />
        <!-- если есть - id обхода в вашей системе -->        
        <id />
        <!-- обязательное поле - доступные значения INSPECTION_ABSENT, INSPECTION_DOOR_IS_NOT_OPENED, INSPECTION_WILL_THINK, INSPECTION_CONTRACT_EXIST, INSPECTION_TTK_CLIENT, INSPECTION_REJECTED -->
        <status>INSPECTION_ABSENT</status>
        <!-- если есть - список конкурентов -->  
        <competitors>
            <competitor>MTS</competitor>
            <competitor>LOCAL.PROVIDER</competitor>
        </competitors>
    </inspection>
</inspections>
```
