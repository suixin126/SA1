const express = require("express");
const bodyParser = require("body-parser");
const app = express();
const PORT = 3000;
const cors = require("cors");
const mysql = require("mysql2/promise");

// 创建数据库连接配置
const pool = mysql.createPool({
  host: "localhost", // 数据库主机名
  user: "root", // 数据库用户名
  password: "123456", // 数据库密码
  database: "db1", // 要连接的数据库名
});

// 使用body-parser中间件来解析请求体
app.use(bodyParser.json());
// 允许跨域请求
app.use(cors());
// 存储联系人信息的内存数组
let contacts = [
  {
    name: "张三",
    phone: "123456789",
    address: "北京市海淀区",
  },
  {
    name: "李四",
    phone: "987654321",
    address: "上海市浦东新区",
  },
];

// 添加联系人
app.post("/contacts", async (req, res) => {
  let connection;
  try {
    // 从连接池中获取连接
    connection = await pool.getConnection();

    // 执行查询
    const [rows] = await connection.execute(
      "INSERT INTO contact (name, phone, address) VALUES (?,?,?)",
      [req.body.name, req.body.phone, req.body.address]
    );

    // 返回结果
    console.log(`Inserted ${rows.affectedRows} rows.`);
  } catch (err) {
    // 处理错误
    console.error("Error executing query:", err);
    res.status(500).json({ error: "Internal Server Error" });
  } finally {
    // 释放连接
    if (connection) {
      connection.release();
    }
  }
  const newContact = req.body;
  contacts.push(newContact);
  res
    .status(201)
    .send({ message: "Contact added successfully", contact: newContact });
});

// 获取所有联系人
app.get("/contacts", async (req, res) => {
  let connection;
  try {
    // 从连接池中获取连接
    connection = await pool.getConnection();

    // 执行查询
    const [rows] = await connection.execute("SELECT * FROM contact");

    // 返回结果
    contacts = rows;
    res.send(contacts);
  } catch (err) {
    // 处理错误
    console.error("Error executing query:", err);
    res.status(500).json({ error: "Internal Server Error" });
  } finally {
    // 释放连接
    if (connection) {
      connection.release();
    }
  }
});
// 更新联系人（根据ID，简化版）
app.put("/contacts/:name", async (req, res) => {
  let connection;
  try {
    // 从连接池中获取连接
    connection = await pool.getConnection();

    // 执行查询
    const [rows] = await connection.execute(
      "UPDATE contact SET phone =?, address =? WHERE name =?",
      [req.body.phone, req.body.address, req.params.name]
    );

    // 返回结果
    console.log(`Updated ${rows.affectedRows} rows.`);
  } catch (err) {
    // 处理错误
    console.error("Error executing query:", err);
    res.status(500).json({ error: "Internal Server Error" });
  } finally {
    // 释放连接
    if (connection) {
      connection.release();
    }
  }

  const name = req.params.name;
  const contactId = contacts.findIndex((contact) => contact.name === name);
  if (contactId !== -1) {
    contacts[contactId] = req.body;
    res.send({
      message: "Contact updated successfully",
      contact: contacts[contactId],
    });
  } else {
    res.status(404).send({ message: "Contact not found" });
  }
});

// 删除联系人（根据ID，简化版）
app.delete("/contacts/:name", async (req, res) => {
  let connection;
  try {
    // 从连接池中获取连接
    connection = await pool.getConnection();

    // 执行查询
    const [rows] = await connection.execute(
      "DELETE FROM contact WHERE name =?",
      [req.params.name]
    );

    // 返回结果
    console.log(`Deleted ${rows.affectedRows} rows.`);
  } catch (err) {
    // 处理错误
    console.error("Error executing query:", err);
    res.status(500).json({ error: "Internal Server Error" });
  } finally {
    // 释放连接
    if (connection) {
      connection.release();
    }
  }

  const contactName = req.params.name;
  const index = contacts.findIndex((contact) => contact.name === contactName);
  if (index !== -1) {
    contacts.splice(index, 1);
    res.send({ message: "Contact deleted successfully" });
  } else {
    res.status(404).send({ message: "Contact not found" });
  }
});

// 启动服务器
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});

