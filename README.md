House.Uploader
=========

House.Uploader - загрузка технического охвата. Краткое описание элементов XML-схемы. Последняя версия схемы расположена здесь http://crm.ttk.ru/schema/uploader/ttk-uploader-1.2.xsd

<span style="color: red">ВАЖНО!</span>
> * Не забывайте о порядке следования тэгов в файле - валидация по схеме укажет, какой элемент расположен некорректно
> * Корректно пишите названия тэгов
> * Номер дома в ФИАС всегда представлен тремя параметрами: номер, корпус, строение. Поэтому если в написании номера присутствует слово ЛИТЕР - в ФИАСе это эквивалент СТРОЕНИЕ
> * В схеме для дома <number> - обязательный тэг, но бывают ситуации, когда у дома есть только строение. В этом случае надо формировать XML файл так:
```xml
    <number></number>
    <structure>2</structure>
    <integratedNumber>стр.2</integratedNumber>
```

Примеры файлов
----
В директории example-xml-files
[ttk-uploader-sample-1.2.xml](../master/example-xml-files)
[ttk-uploader-sample-bad-1.2.xml](../master/example-xml-files)


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

Описание элементов
----
Описание элементов в [WIKI](https://github.com/TRANSTK/house.uploader/wiki/%D0%9A%D1%80%D0%B0%D1%82%D0%BA%D0%BE%D0%B5-%D0%BE%D0%BF%D0%B8%D1%81%D0%B0%D0%BD%D0%B8%D0%B5-%D1%8D%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82%D0%BE%D0%B2-XML-%D1%81%D1%85%D0%B5%D0%BC%D1%8B)


Валидация сгенерированного XML файла
----

Java код валидации [uploader-java-validator](../master/uploader-java-validator)
Подробности в wiki [Валидация файла] (https://github.com/TRANSTK/house.uploader/wiki/%D0%9F%D1%80%D0%B8%D0%BC%D0%B5%D1%80-%D0%B2%D0%B0%D0%BB%D0%B8%D0%B4%D0%B0%D1%86%D0%B8%D0%B8-XML-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0-%D0%BF%D0%BE-XSD-%D1%84%D0%B0%D0%B9%D0%BB%D1%83)

