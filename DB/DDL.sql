CREATE DATABASE esunbankdb;
use esunbankdb;

-- 創建 User 表
CREATE TABLE [User] (
    [User ID] INT IDENTITY(1,1) PRIMARY KEY,
    [User Name] NVARCHAR(255) NOT NULL,
    [Email] NVARCHAR(255) NOT NULL UNIQUE,
    [Password] NVARCHAR(255) NOT NULL,
    [Cover Image] NVARCHAR(255),
    [Biography] NVARCHAR(MAX)
);

-- 創建 Post 表
CREATE TABLE [Post] (
    [Post ID] INT IDENTITY(1,1) PRIMARY KEY,
    [User ID] INT NOT NULL,
    [Content] NVARCHAR(MAX) NOT NULL,
    [Image] NVARCHAR(255),
    [Created At] DATETIME NOT NULL,
    CONSTRAINT [FK_Post_User] FOREIGN KEY ([User ID]) REFERENCES [User]([User ID])
);

-- 創建 Comment 表
CREATE TABLE [Comment] (
    [Comment ID] INT IDENTITY(1,1) PRIMARY KEY,
    [User ID] INT NOT NULL,
    [Post ID] INT NOT NULL,
    [Content] NVARCHAR(MAX) NOT NULL,
    [Created At] DATETIME NOT NULL,
    CONSTRAINT [FK_Comment_User] FOREIGN KEY ([User ID]) REFERENCES [User]([User ID]),
    CONSTRAINT [FK_Comment_Post] FOREIGN KEY ([Post ID]) REFERENCES [Post]([Post ID])
);