USE [master]
GO
/****** Object:  Database [QLKS_HDV]    Script Date: 14-Jun-21 5:29:48 PM ******/
CREATE DATABASE [QLKS_HDV]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLKS_HDV', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\QLKS_HDV.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLKS_HDV_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\QLKS_HDV_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLKS_HDV] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLKS_HDV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLKS_HDV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLKS_HDV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLKS_HDV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLKS_HDV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLKS_HDV] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLKS_HDV] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLKS_HDV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLKS_HDV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLKS_HDV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLKS_HDV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLKS_HDV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLKS_HDV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLKS_HDV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLKS_HDV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLKS_HDV] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLKS_HDV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLKS_HDV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLKS_HDV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLKS_HDV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLKS_HDV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLKS_HDV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLKS_HDV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLKS_HDV] SET RECOVERY FULL 
GO
ALTER DATABASE [QLKS_HDV] SET  MULTI_USER 
GO
ALTER DATABASE [QLKS_HDV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLKS_HDV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLKS_HDV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLKS_HDV] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QLKS_HDV] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLKS_HDV', N'ON'
GO
USE [QLKS_HDV]
GO
/****** Object:  Table [dbo].[Booking_card]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Booking_card](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[customer_id] [int] NULL,
	[discount_id] [int] NULL,
	[status] [varchar](10) NULL,
	[price] [int] NULL,
	[complete_at] [nchar](20) NULL,
 CONSTRAINT [PK_Booking_card] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Booking_Detail]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking_Detail](
	[bookingcard_id] [int] NOT NULL,
	[type_id] [int] NOT NULL,
	[recieve_at] [date] NOT NULL,
	[back_at] [date] NULL,
	[amount] [int] NULL,
	[price] [int] NULL,
 CONSTRAINT [PK_Booking] PRIMARY KEY CLUSTERED 
(
	[bookingcard_id] ASC,
	[type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Customer]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[firstname] [nvarchar](50) NULL,
	[lastname] [nvarchar](50) NULL,
	[phone] [varchar](15) NULL,
	[email] [varchar](500) NULL,
	[username] [varchar](30) NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Customer_Renting]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customer_Renting](
	[bookingcard_id] [int] NOT NULL,
	[room_code] [varchar](10) NOT NULL,
	[customer_id] [int] NOT NULL,
 CONSTRAINT [PK_Customer_Renting_1] PRIMARY KEY CLUSTERED 
(
	[bookingcard_id] ASC,
	[room_code] ASC,
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discount](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[discount_name] [nvarchar](50) NULL,
	[discount_value] [float] NULL,
	[use_at] [date] NULL,
	[end_at] [date] NULL,
 CONSTRAINT [PK_Discount] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Hotel]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hotel](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[hotel_name] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
	[logo] [nvarchar](50) NULL,
 CONSTRAINT [PK_Hotel] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Price]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Price](
	[type_id] [int] NOT NULL,
	[weekend] [bit] NOT NULL,
	[price] [nchar](10) NULL,
 CONSTRAINT [PK_Price] PRIMARY KEY CLUSTERED 
(
	[type_id] ASC,
	[weekend] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Renting_Detail]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Renting_Detail](
	[bookingcard_id] [int] NOT NULL,
	[room_code] [varchar](10) NOT NULL,
	[rent_at] [date] NULL,
	[back_at] [date] NULL,
	[staff_id] [int] NULL,
 CONSTRAINT [PK_Renting_1] PRIMARY KEY CLUSTERED 
(
	[bookingcard_id] ASC,
	[room_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roles](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [varchar](50) NULL,
	[hotel_id] [int] NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Room]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room](
	[code] [varchar](10) NOT NULL,
	[type_id] [int] NULL,
	[description] [nvarchar](200) NULL,
	[image] [nchar](50) NULL,
 CONSTRAINT [PK_Room_1] PRIMARY KEY CLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Room_type]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room_type](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[number_of_bed] [int] NULL,
	[name] [varchar](15) NULL,
	[desciption] [nvarchar](200) NULL,
 CONSTRAINT [PK_Room_type] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Service]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Service](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[service_name] [nvarchar](50) NULL,
	[price] [int] NULL,
	[image] [varchar](50) NULL,
 CONSTRAINT [PK_Service] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Service_Detail]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service_Detail](
	[bookingcard_id] [int] NOT NULL,
	[service_id] [int] NOT NULL,
	[quantity] [int] NULL,
	[price] [int] NULL,
 CONSTRAINT [PK_Booking_Service] PRIMARY KEY CLUSTERED 
(
	[bookingcard_id] ASC,
	[service_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Staff]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Staff](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[firstname] [nvarchar](50) NULL,
	[lastname] [nvarchar](50) NULL,
	[phone] [varchar](15) NULL,
	[email] [varchar](50) NULL,
	[address] [nvarchar](100) NULL,
	[username] [varchar](30) NULL,
 CONSTRAINT [PK_Staff] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 14-Jun-21 5:29:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[username] [varchar](30) NOT NULL,
	[password] [varchar](50) NULL,
	[role_id] [int] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Booking_card] ON 

INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (12, 3, NULL, N'Completed', 0, N'2021-06-14          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (13, 2, NULL, N'Reservated', 0, N'2021-06-13          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (14, 2, NULL, N'Cancel', 0, N'2021-06-13          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (15, 2, NULL, N'Processing', 53235000, N'2021-06-14          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (17, 4, NULL, N'Renting', 8220000, N'2021-06-13          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (18, 4, NULL, N'Processing', 460000, N'2021-06-13          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (19, 6, NULL, N'Cancel', 12250000, N'2021-06-13          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (20, 6, NULL, N'Cancel', 4170000, N'2021-6-14           ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (21, 6, NULL, N'Renting', 47030000, N'2021-07-23          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (22, 6, NULL, N'Reservated', 8650000, N'2021-06-14          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (24, 6, NULL, N'Reservated', 177220000, N'2021-08-26          ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (25, 6, NULL, N'Reservated', 3150000, N'2021-7-15           ')
INSERT [dbo].[Booking_card] ([id], [customer_id], [discount_id], [status], [price], [complete_at]) VALUES (26, 6, NULL, N'Processing', 120000, N'2021-7-14           ')
SET IDENTITY_INSERT [dbo].[Booking_card] OFF
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (12, 1, CAST(N'2011-11-11' AS Date), CAST(N'2011-11-12' AS Date), 2, 50000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (12, 2, CAST(N'2011-11-11' AS Date), CAST(N'2011-11-12' AS Date), 2, 50000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (14, 2, CAST(N'2011-11-11' AS Date), CAST(N'2011-11-12' AS Date), 2, 50000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (14, 3, CAST(N'2011-11-14' AS Date), CAST(N'2011-11-18' AS Date), 5, 50000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (15, 1, CAST(N'2021-06-10' AS Date), CAST(N'2021-06-12' AS Date), 5, 1200000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (15, 2, CAST(N'2021-06-10' AS Date), CAST(N'2021-06-12' AS Date), 3, 1750000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (15, 3, CAST(N'2021-06-10' AS Date), CAST(N'2021-06-14' AS Date), 2, 2700000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (15, 4, CAST(N'2011-11-14' AS Date), CAST(N'2011-11-18' AS Date), 5, 3250000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (15, 5, CAST(N'2011-11-14' AS Date), CAST(N'2011-11-18' AS Date), 5, 4000000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (17, 1, CAST(N'2021-06-11' AS Date), CAST(N'2021-06-13' AS Date), 6, 1350000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (19, 1, CAST(N'2021-06-12' AS Date), CAST(N'2021-06-13' AS Date), 6, 1000000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (19, 3, CAST(N'2021-06-12' AS Date), CAST(N'2021-06-13' AS Date), 5, 1200000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (20, 1, CAST(N'2021-06-12' AS Date), CAST(N'2021-06-14' AS Date), 3, 1350000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (21, 1, CAST(N'2021-07-15' AS Date), CAST(N'2021-07-23' AS Date), 5, 3450000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (21, 5, CAST(N'2021-07-15' AS Date), CAST(N'2021-07-23' AS Date), 4, 7400000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (22, 1, CAST(N'2021-06-13' AS Date), CAST(N'2021-06-14' AS Date), 5, 850000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (22, 3, CAST(N'2021-06-13' AS Date), CAST(N'2021-06-14' AS Date), 4, 1100000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (24, 1, CAST(N'2021-06-12' AS Date), CAST(N'2021-06-14' AS Date), 4, 1350000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (24, 2, CAST(N'2021-08-05' AS Date), CAST(N'2021-08-26' AS Date), 5, 12500000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (24, 5, CAST(N'2021-08-05' AS Date), CAST(N'2021-08-26' AS Date), 6, 18200000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (25, 1, CAST(N'2021-07-13' AS Date), CAST(N'2021-07-15' AS Date), 3, 1050000)
INSERT [dbo].[Booking_Detail] ([bookingcard_id], [type_id], [recieve_at], [back_at], [amount], [price]) VALUES (26, 1, CAST(N'2021-07-14' AS Date), CAST(N'2021-07-14' AS Date), 5, 0)
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([id], [firstname], [lastname], [phone], [email], [username]) VALUES (2, N'Lê Hà', N'Tĩnh', N'0836157441', N'nguyenvinhlam@gmail.com', N'tien156')
INSERT [dbo].[Customer] ([id], [firstname], [lastname], [phone], [email], [username]) VALUES (3, N'Nguyễn Văn', N'Tín', N'075158321', N'nguyenvan@gmail.com', N'tien157')
INSERT [dbo].[Customer] ([id], [firstname], [lastname], [phone], [email], [username]) VALUES (4, N'NT', N'Dun', N'0941853369', N'ntd051099@gmail.com', N'dun05')
INSERT [dbo].[Customer] ([id], [firstname], [lastname], [phone], [email], [username]) VALUES (5, N'tt', N't', N'0941853369', N't@gmail.com', N'dungi')
INSERT [dbo].[Customer] ([id], [firstname], [lastname], [phone], [email], [username]) VALUES (6, N'hiii', N'hi', N'0941853369', N'finnguyen99@gmail.com', N'ny')
SET IDENTITY_INSERT [dbo].[Customer] OFF
SET IDENTITY_INSERT [dbo].[Discount] ON 

INSERT [dbo].[Discount] ([id], [discount_name], [discount_value], [use_at], [end_at]) VALUES (3, N'giảm giá theo khách đoàn', 0.30000001192092896, CAST(N'2021-01-01' AS Date), CAST(N'2021-12-12' AS Date))
SET IDENTITY_INSERT [dbo].[Discount] OFF
SET IDENTITY_INSERT [dbo].[Hotel] ON 

INSERT [dbo].[Hotel] ([id], [hotel_name], [description], [logo]) VALUES (1, N'Silver Lining', N'Mèo méo meo mèo meo', N'  ')
SET IDENTITY_INSERT [dbo].[Hotel] OFF
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (1, 0, N'350000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (1, 1, N'500000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (2, 0, N'500000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (2, 1, N'750000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (3, 0, N'500000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (3, 1, N'600000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (4, 0, N'650000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (4, 1, N'800000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (5, 0, N'800000    ')
INSERT [dbo].[Price] ([type_id], [weekend], [price]) VALUES (5, 1, N'900000    ')
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([id], [role_name], [hotel_id]) VALUES (1, N'Manager', 1)
INSERT [dbo].[Roles] ([id], [role_name], [hotel_id]) VALUES (2, N'Reception', 1)
INSERT [dbo].[Roles] ([id], [role_name], [hotel_id]) VALUES (3, N'Cleaner', 1)
INSERT [dbo].[Roles] ([id], [role_name], [hotel_id]) VALUES (4, N'Customer', 1)
SET IDENTITY_INSERT [dbo].[Roles] OFF
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'101', 2, N'Meo Meo', NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'102', 1, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'103', 2, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'104', 1, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'105', 1, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'201', 1, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'202', 1, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'203', 2, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'204', 2, NULL, NULL)
INSERT [dbo].[Room] ([code], [type_id], [description], [image]) VALUES (N'205', 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Room_type] ON 

INSERT [dbo].[Room_type] ([id], [number_of_bed], [name], [desciption]) VALUES (1, 3, N'Standard', NULL)
INSERT [dbo].[Room_type] ([id], [number_of_bed], [name], [desciption]) VALUES (2, 1, N'Superior', NULL)
INSERT [dbo].[Room_type] ([id], [number_of_bed], [name], [desciption]) VALUES (3, 2, N'Deluxe', NULL)
INSERT [dbo].[Room_type] ([id], [number_of_bed], [name], [desciption]) VALUES (4, 4, N'SUITE', NULL)
INSERT [dbo].[Room_type] ([id], [number_of_bed], [name], [desciption]) VALUES (5, 5, N'Connecting', NULL)
SET IDENTITY_INSERT [dbo].[Room_type] OFF
SET IDENTITY_INSERT [dbo].[Service] ON 

INSERT [dbo].[Service] ([id], [service_name], [price], [image]) VALUES (2, N'Giặt ủi', 35000, N'mimi.png')
INSERT [dbo].[Service] ([id], [service_name], [price], [image]) VALUES (3, N'Ăn sáng', 40000, N'meomeo.png')
INSERT [dbo].[Service] ([id], [service_name], [price], [image]) VALUES (4, N'Nước uống', 30000, N'hihi.png')
SET IDENTITY_INSERT [dbo].[Service] OFF
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (12, 2, 3, 35000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (13, 2, 3, 35000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (13, 3, 3, 35000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (14, 3, 3, 35000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (15, 2, 4, 35000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (15, 3, 3, 35000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (15, 4, 3, 30000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (17, 4, 4, 30000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (18, 2, 4, 35000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (18, 3, 8, 40000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (19, 3, 4, 40000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (19, 4, 3, 30000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (20, 3, 3, 40000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (21, 4, 6, 30000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (24, 3, 3, 40000)
INSERT [dbo].[Service_Detail] ([bookingcard_id], [service_id], [quantity], [price]) VALUES (26, 4, 4, 30000)
SET IDENTITY_INSERT [dbo].[Staff] ON 

INSERT [dbo].[Staff] ([id], [firstname], [lastname], [phone], [email], [address], [username]) VALUES (1, N'Nguyễn Thái', N'Bảo', N'0836877964', N'nguyenthaibao157@gmail.com', N'Đồng Tháp', N'bao156')
INSERT [dbo].[Staff] ([id], [firstname], [lastname], [phone], [email], [address], [username]) VALUES (10, N'Nguyễn Đức', N'Tài', N'0836811742', N'nguyentaido@gmail.com', N'An Giang', N'bao157')
SET IDENTITY_INSERT [dbo].[Staff] OFF
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'bao156', N'123456', 1)
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'bao157', N'123456', 2)
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'dun05', N'12345', 4)
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'dung', N'dung', 4)
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'dungi', N'456', 4)
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'ny', N'567', 4)
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'tien156', N'123', 4)
INSERT [dbo].[Users] ([username], [password], [role_id]) VALUES (N'tien157', N'123', 4)
ALTER TABLE [dbo].[Booking_card]  WITH CHECK ADD  CONSTRAINT [FK_Booking_card_Customer] FOREIGN KEY([customer_id])
REFERENCES [dbo].[Customer] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Booking_card] CHECK CONSTRAINT [FK_Booking_card_Customer]
GO
ALTER TABLE [dbo].[Booking_card]  WITH CHECK ADD  CONSTRAINT [FK_Booking_card_Discount] FOREIGN KEY([discount_id])
REFERENCES [dbo].[Discount] ([id])
GO
ALTER TABLE [dbo].[Booking_card] CHECK CONSTRAINT [FK_Booking_card_Discount]
GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_booking_detail_Booking_card] FOREIGN KEY([bookingcard_id])
REFERENCES [dbo].[Booking_card] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_booking_detail_Booking_card]
GO
ALTER TABLE [dbo].[Booking_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Detail_Room_type1] FOREIGN KEY([type_id])
REFERENCES [dbo].[Room_type] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Booking_Detail] CHECK CONSTRAINT [FK_Booking_Detail_Room_type1]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Users1] FOREIGN KEY([username])
REFERENCES [dbo].[Users] ([username])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Users1]
GO
ALTER TABLE [dbo].[Customer_Renting]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Renting_Customer] FOREIGN KEY([customer_id])
REFERENCES [dbo].[Customer] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Customer_Renting] CHECK CONSTRAINT [FK_Customer_Renting_Customer]
GO
ALTER TABLE [dbo].[Customer_Renting]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Renting_Renting] FOREIGN KEY([bookingcard_id], [room_code])
REFERENCES [dbo].[Renting_Detail] ([bookingcard_id], [room_code])
GO
ALTER TABLE [dbo].[Customer_Renting] CHECK CONSTRAINT [FK_Customer_Renting_Renting]
GO
ALTER TABLE [dbo].[Price]  WITH CHECK ADD  CONSTRAINT [FK_Price_Room_type] FOREIGN KEY([type_id])
REFERENCES [dbo].[Room_type] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Price] CHECK CONSTRAINT [FK_Price_Room_type]
GO
ALTER TABLE [dbo].[Renting_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Renting_Booking_card] FOREIGN KEY([bookingcard_id])
REFERENCES [dbo].[Booking_card] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Renting_Detail] CHECK CONSTRAINT [FK_Renting_Booking_card]
GO
ALTER TABLE [dbo].[Renting_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Renting_Room] FOREIGN KEY([room_code])
REFERENCES [dbo].[Room] ([code])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Renting_Detail] CHECK CONSTRAINT [FK_Renting_Room]
GO
ALTER TABLE [dbo].[Renting_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Renting_Staff] FOREIGN KEY([staff_id])
REFERENCES [dbo].[Staff] ([id])
GO
ALTER TABLE [dbo].[Renting_Detail] CHECK CONSTRAINT [FK_Renting_Staff]
GO
ALTER TABLE [dbo].[Roles]  WITH CHECK ADD  CONSTRAINT [FK_Roles_Hotel] FOREIGN KEY([hotel_id])
REFERENCES [dbo].[Hotel] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Roles] CHECK CONSTRAINT [FK_Roles_Hotel]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_Room_type] FOREIGN KEY([type_id])
REFERENCES [dbo].[Room_type] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_Room_type]
GO
ALTER TABLE [dbo].[Service_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Service_Detail_Booking_card] FOREIGN KEY([bookingcard_id])
REFERENCES [dbo].[Booking_card] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Service_Detail] CHECK CONSTRAINT [FK_Service_Detail_Booking_card]
GO
ALTER TABLE [dbo].[Service_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Service_Detail_Service] FOREIGN KEY([service_id])
REFERENCES [dbo].[Service] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Service_Detail] CHECK CONSTRAINT [FK_Service_Detail_Service]
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_Staff_Users] FOREIGN KEY([username])
REFERENCES [dbo].[Users] ([username])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_Staff_Users]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Roles] FOREIGN KEY([role_id])
REFERENCES [dbo].[Roles] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Roles]
GO
USE [master]
GO
ALTER DATABASE [QLKS_HDV] SET  READ_WRITE 
GO
