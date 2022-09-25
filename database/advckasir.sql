-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2020 at 08:06 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `advckasir`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `nama_barang` varchar(100) NOT NULL,
  `kode_barang` int(100) NOT NULL,
  `satuan_barang` varchar(100) NOT NULL,
  `stok_barang` int(100) NOT NULL,
  `hargabeli_barang` int(100) NOT NULL,
  `hargajual_barang` int(100) NOT NULL,
  `waktumasuk_barang` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`nama_barang`, `kode_barang`, `satuan_barang`, `stok_barang`, `hargabeli_barang`, `hargajual_barang`, `waktumasuk_barang`) VALUES
('Ale Ale 200 ml Anggur', 10938, 'PCs', 44, 687, 900, '2020-06-01'),
('Alkohol 70% 50 ml Kapal', 10284, 'Botol', 47, 2750, 3250, '2020-06-07'),
('Apache Filter 12', 10927, 'PCs', 50, 13500, 14000, '2020-06-01'),
('Apache Kretek 12', 10001, 'PCs', 49, 9400, 1000, '2020-06-01'),
('Aqua Botol 1500 ml', 10032, 'Botol', 43, 3766, 4300, '2020-06-04'),
('Aqua Botol 600 ml', 10028, 'Botol', 27, 1745, 2000, '2020-06-05'),
('Bango Kecap 135 ml', 10112, 'Botol', 39, 7751, 8300, '2020-06-03'),
('Bebelac 1 800 gr', 10991, 'Kaleng', 47, 99473, 101000, '2020-06-01'),
('Bendera 123 400 gr Coklat', 10212, 'Dos', 40, 38900, 39900, '2020-06-02'),
('Beng Beng Peanut 25 gr', 10232, 'PCs', 47, 1261, 1400, '2020-06-02'),
('Betadine Hygiene 60 ml', 10822, 'Botol', 28, 16280, 17500, '2020-06-02'),
('Bintang Buana Filter', 10238, 'PCs', 39, 14100, 14500, '2020-06-02'),
('Bintang Buana Kretek', 10211, 'PCs', 49, 11050, 11500, '2020-06-02'),
('Cap Lang GPU 30 ml', 10100, 'PCs', 34, 7837, 8700, '2020-06-06'),
('Chitato 35 gr Sapi Panggang', 10230, 'PCs', 27, 4178, 4700, '2020-06-02'),
('Cimory 250 ml Anggur', 10216, 'Botol', 39, 6600, 7500, '2020-06-05'),
('Counterpain 15 gr', 10443, 'PCs', 30, 22660, 24400, '2020-06-02'),
('Djarum Super Coklat', 10947, 'PCs', 38, 19000, 21000, '2020-06-02'),
('Djarum Super Mild', 10529, 'PCs', 47, 23500, 26500, '2020-06-02'),
('Dji Sam  Soe Kretek Kuning', 10563, 'PCs', 34, 17000, 19000, '2020-06-03'),
('Dunhil Hitam', 10222, 'PCs', 47, 23000, 25000, '2020-06-08'),
('Dunhil Putih', 10824, 'PCs', 25, 21000, 24000, '2020-06-03'),
('Gudang Garam Internasional Filter', 10397, 'PCs', 42, 18500, 20500, '2020-06-02'),
('LA Bold', 10824, 'PCs', 37, 14100, 16000, '2020-06-01'),
('Magnum Biru', 10735, 'PCs', 43, 25000, 27000, '2020-06-03'),
('Magnum Hitam', 10293, 'PCs', 44, 18000, 20000, '2020-06-01'),
('Malboro Biru', 10372, 'PCs', 28, 27000, 28000, '2020-06-07'),
('Malboro Hitam', 10648, 'PCs', 40, 28000, 30000, '2020-06-03'),
('Malboro Merah', 10432, 'PCs', 48, 31500, 33500, '2020-06-03'),
('Sampoerna Mild', 10937, 'PCs', 46, 25000, 27000, '2020-06-02'),
('Sampoerna Mild Hijau', 10036, 'PCs', 43, 28000, 30000, '2020-06-02'),
('Sampoerna Mild Merah', 10034, 'PCs', 57, 25000, 27000, '2020-06-02'),
('Surya Pro', 10111, 'PCs', 36, 18600, 20000, '2020-06-02'),
('Surya Pro Merah', 10840, 'PCs', 45, 18000, 20000, '2020-06-01'),
('Surya Profesional', 10392, 'PCs', 44, 18500, 20500, '2020-06-03'),
('U Mild', 10999, 'PCs', 35, 21500, 23000, '2020-06-02'),
('Zee 600 ml', 10192, 'Botol', 27, 1900, 3000, '2020-05-27');

-- --------------------------------------------------------

--
-- Table structure for table `daftar_belanja`
--

CREATE TABLE `daftar_belanja` (
  `id_daftarbelanja` int(100) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `kode_barang` int(100) NOT NULL,
  `satuan_barang` varchar(100) NOT NULL,
  `hargasatuan_barang` int(100) NOT NULL,
  `jumlah_barang` int(100) NOT NULL,
  `subtotal_barang` int(100) NOT NULL,
  `hargabeli_barang` int(100) NOT NULL,
  `hpp` int(100) NOT NULL,
  `laba` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Triggers `daftar_belanja`
--
DELIMITER $$
CREATE TRIGGER `batal` AFTER DELETE ON `daftar_belanja` FOR EACH ROW BEGIN
UPDATE barang SET stok_barang = stok_barang + OLD.jumlah_barang
WHERE nama_barang = OLD.nama_barang;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `beli` AFTER INSERT ON `daftar_belanja` FOR EACH ROW BEGIN
UPDATE barang SET stok_barang = stok_barang - new.jumlah_barang
WHERE nama_barang = new.`nama_barang`;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `faktur`
--

CREATE TABLE `faktur` (
  `no_faktur` varchar(100) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `kode_barang` int(100) NOT NULL,
  `satuan_barang` varchar(100) NOT NULL,
  `hargasatuan_barang` int(100) NOT NULL,
  `jumlah_barang` int(100) NOT NULL,
  `subtotal_barang` int(100) NOT NULL,
  `bayar_barang` int(100) NOT NULL,
  `kembalian_barang` int(100) NOT NULL,
  `tanggal` date NOT NULL,
  `hargabeli_barang` int(100) NOT NULL,
  `hpp` int(100) NOT NULL,
  `laba` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faktur`
--

INSERT INTO `faktur` (`no_faktur`, `nama_barang`, `kode_barang`, `satuan_barang`, `hargasatuan_barang`, `jumlah_barang`, `subtotal_barang`, `bayar_barang`, `kembalian_barang`, `tanggal`, `hargabeli_barang`, `hpp`, `laba`) VALUES
('F0001', 'Aqua Botol 1500 ml', 10032, 'Botol', 4300, 1, 4300, 15000, 950, '2020-06-08', 3766, 3766, 534),
('F0001', 'Alkohol 70% 50 ml Kapal', 10284, 'Botol', 3250, 3, 9750, 15000, 950, '2020-06-08', 2750, 8250, 1500),
('F0002', 'Betadine Hygiene 60 ml', 10822, 'Botol', 17500, 2, 35000, 200000, 2500, '2020-06-08', 16280, 32560, 2440),
('F0002', 'Bebelac 1 800 gr', 10991, 'Kaleng', 101000, 1, 101000, 200000, 2500, '2020-06-08', 99473, 99473, 1527),
('F0002', 'Gudang Garam Internasional Filter', 10397, 'PCs', 20500, 3, 61500, 200000, 2500, '2020-06-08', 18500, 55500, 6000),
('F0003', 'Ale Ale 200 ml Anggur', 10938, 'PCs', 900, 3, 2700, 24000, 800, '2020-06-09', 687, 2061, 639),
('F0003', 'Bintang Buana Kretek', 10211, 'PCs', 11500, 1, 11500, 24000, 800, '2020-06-09', 11050, 11050, 450),
('F0003', 'Zee 600 ml', 10192, 'Botol', 3000, 3, 9000, 24000, 800, '2020-06-09', 1900, 5700, 3300);

-- --------------------------------------------------------

--
-- Table structure for table `user_gudang`
--

CREATE TABLE `user_gudang` (
  `id` int(100) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `hp` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_gudang`
--

INSERT INTO `user_gudang` (`id`, `nama`, `username`, `password`, `hp`, `email`, `alamat`) VALUES
(1, 'Muhammad Akbar Hamid', 'akbarhamid', 'akbar123', '89538687067', 'akbarhamid@gmail.com', 'Jl. Giri Kencana'),
(2, 'I Dewa Ngurah Tri Hendrawan', 'dewangurah', 'ngurah123', '81325274923', 'dewangurah@gmail.com', 'Jl. Sesetan'),
(3, 'Kadek Vincky Sedana', 'vinckysedana', 'vincky123', '85382495034', 'vinckysedana@gmail.com', 'Jl. Pemogan'),
(4, 'Calvin Christian', 'calvinchristian', 'calvin123', '83124923742', 'calvinchristian@gmail.com', 'Jl. Kampus Unud'),
(6, 'root', 'botol', 'cocacola', '123', 'root', 'root'),
(8, 'gudang', 'gudang', 'gudang', '123', 'gudang', 'gudang');

-- --------------------------------------------------------

--
-- Table structure for table `user_kasir`
--

CREATE TABLE `user_kasir` (
  `id` int(100) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `hp` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_kasir`
--

INSERT INTO `user_kasir` (`id`, `nama`, `username`, `password`, `hp`, `email`, `alamat`) VALUES
(1, 'Muhammad Akbar Hamid', 'akbarhamid', 'akbar123', '89538687067', 'akbarhamid@gmail.com', 'Jl. Giri Kencana'),
(2, 'I Dewa Ngurah Tri Hendrawan', 'dewangurah', 'ngurah123', '81325274923', 'dewangurah@gmail.com', 'Jl. Sesetan'),
(3, 'Kadek Vincky Sedana', 'vinckysedana', 'vincky123', '85382495034', 'vinckysedana@gmail.com', 'Jl. Pemogan'),
(4, 'Calvin Christian', 'calvinchristian', 'calvin123', '83124923742', 'calvinchristian@gmail.com', 'Jl. Kampus Unud'),
(5, 'kasir', 'kasir', 'kasir', '123', 'kasir', 'kasir');

-- --------------------------------------------------------

--
-- Table structure for table `user_manajer`
--

CREATE TABLE `user_manajer` (
  `id` int(100) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `hp` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_manajer`
--

INSERT INTO `user_manajer` (`id`, `nama`, `username`, `password`, `hp`, `email`, `alamat`) VALUES
(1, 'Muhammad Akbar Hamid', 'akbarhamid', 'akbar123', '89538687067', 'akbarhamid@gmail.com', 'Jl. Giri Kencana'),
(2, 'I Dewa Ngurah Tri Hendrawan', 'dewangurah', 'ngurah123', '81325274923', 'dewangurah@gmail.com', 'Jl. Sesetan'),
(3, 'Kadek Vincky Sedana', 'vinckysedana', 'vincky123', '85382495034', 'vinckysedana@gmail.com', 'Jl. Pemogan'),
(4, 'Calvin Christian', 'calvinchristian', 'calvin123', '83124923742', 'calvinchristian@gmail.com', 'Jl. Kampus Unud'),
(5, 'manajer', 'manajer', 'manajer', '123', 'manajer', 'manajer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`nama_barang`);

--
-- Indexes for table `daftar_belanja`
--
ALTER TABLE `daftar_belanja`
  ADD PRIMARY KEY (`id_daftarbelanja`);

--
-- Indexes for table `user_gudang`
--
ALTER TABLE `user_gudang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_kasir`
--
ALTER TABLE `user_kasir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_manajer`
--
ALTER TABLE `user_manajer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `daftar_belanja`
--
ALTER TABLE `daftar_belanja`
  MODIFY `id_daftarbelanja` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_gudang`
--
ALTER TABLE `user_gudang`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user_kasir`
--
ALTER TABLE `user_kasir`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_manajer`
--
ALTER TABLE `user_manajer`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
