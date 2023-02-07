# �������� ������� superkassa.ru

��������������� �������:
��������������� ������� � ���� ������ postgres. ��� ������������ � �������� ������� ������ ����� ��������������� ���������.

```
dropdb --if-exists sk_example_db
    dropuser --if-exists sk_example_user
    createuser sk_example_user -P
    createdb -O sk_example_user sk_example_db
    psql -U sk_example_user -d sk_example_db <<EOF
    CREATE TABLE sk_example_table (id SERIAL, obj JSONB NOT NULL, PRIMARY KEY(id));
    INSERT INTO sk_example_table (obj) VALUES ('{"current":0}'::JSONB);
    EOF
```

������� ������:
Spring ���������� � ���������� POST ������� �� ���� /modify

������ ������������� JSON �����:
```
{
    "id": <number>,
    "add": <number>
}
```
����� ������������� JSON �����:
```
{
    "current": <number>
}
```
� �������� ��������� ���������� �������� ��������� �� �������� add �������� ���� current ������� obj ������
���������������� id � ������� sk_example_table, � ������� ��������� �������� ����� API.
� ������ ������������� �������� ��������, ������� http ������ 418.


��. resources/post-requests.http ����� ��������� post-������� �� ��������� ������ � �������