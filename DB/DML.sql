USE esunbankdb;

-- ���J User ���
INSERT INTO [User] ([User Name], [Email], [Password], [Cover Image], [Biography])
VALUES 
('0912345678', 'john.doe@example.com', 'password123', 'coverimage1.jpg', 'Biography of John Doe'),
('0987654321', 'jane.smith@example.com', 'password123', 'coverimage2.jpg', 'Biography of Jane Smith');

-- ���J Post ���
INSERT INTO [Post] ([User ID], [Content], [Image], [Created At])
VALUES 
(1, 'This is a post by John', 'image1.jpg', GETDATE()),
(2, 'This is a post by Jane', 'image2.jpg', GETDATE());

-- ���J Comment ���
INSERT INTO [Comment] ([User ID], [Post ID], [Content], [Created At])
VALUES 
(1, 1, 'This is a comment by John on his post', GETDATE()),
(2, 1, 'This is a comment by Jane on John''s post', GETDATE());
