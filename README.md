# ListView_Fragment_Timer

Link video demo: https://www.youtube.com/watch?v=1KqsC7L6KTc

connect to SQLite: MySQLiteOpenHelper.java

```javascript
private static String DB_PATH = "/data/data/com.example.hoangyen.myapp/databases/";//duong dan den data
private static String DB_NAME = "Meovat.db";// ten data
```

Create Fragment:
xml: bottombar_layout
java: bottom_bar.java

ListView get data from sqlite: list_menu_of_title.class
```javascript
dataHelper = new MySQLiteOpenHelper(list_menu_of_title.this);
```

```javascript
String sql = "select * from AmThuc" ;
cursor = dataHelper.SELECTSQL(sql);
while (cursor.moveToNext()) {// chay tu dong trong cursor
            String id = cursor.getString(cursor
                    .getColumnIndex(MySQLiteOpenHelper.CL_id)); // gan gai tri id bang cach lay gia tri cot CL_id trong cursor
            tenmonan = cursor.getString(cursor
                    .getColumnIndex(MySQLiteOpenHelper.CL_TenMonAn));
           hinhanh = cursor.getString(cursor
                    .getColumnIndex(MySQLiteOpenHelper.CL_HinhAnh));

        }
```

Timer:
```javascript
Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);// cho trong 4s sau se chuyen activity moi

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                    Intent i = new Intent(MainActivity.this, Menu_list.class);
                    finish();
                    startActivity(i);// bat dau chuyen activity
                }
            }
        };
        timer.start();
```
