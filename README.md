# TeachMeSkills_C26_Project_M

Этот репозиторий содержит в себе курсовой проект(программу обработки финансовых документов).

Проект нацелен на создание программы для обработки платежных документов и генерации финансовых отчетов. Для доступа к программе требуется аутентификация пользователя с использованием логина и пароля. Программа предназначена для обработки трех типов финансовых документов: инвойсов, ордеров и чеков, все они в формате текста (txt). Основная цель - считывание информации из этих документов, составление статистики и предоставление всестороннего финансового обзора.

Особенности

Аутентификация пользователя: Доступ к программе ограничен и требует ввода действительного логина и пароля.
Обработка документов: Программа принимает путь к папке, содержащей финансовые документы, считывает информацию и составляет статистику.
Типы документов: Поддерживаются три типа документов: инвойсы, ордеры и чеки. Каждый тип документа имеет свою структуру и шаблон именования.
Обработка текущего года: Программа обрабатывает только файлы текущего года(2023).
Техническая документация: Код следует модели C4 для технической документации. 
Обработка ошибок: Внедрены различные проверки для обеспечения надежного выполнения. 
Журналирование: Программа генерирует журналы и сохраняет их в отдельном файле. 
Журналы разделяются на общую информацию и информацию об ошибках.
Обработка невалидных файлов: После обработки все невалидные файлы перемещаются в отдельную папку. 
Финальная статистика: Сводка статистики сохраняется в отдельный файл, включая общий оборот за год и оборот по каждому типу документа.
