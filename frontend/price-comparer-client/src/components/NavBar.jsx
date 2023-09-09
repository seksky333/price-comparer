import Link from "next/link";

export default function NavBar() {
  return (
    <nav>
      <ul className="flex gap-2">
        <li>
          <Link href="/" className="text-green-400 hover:underline">
            Home
          </Link>
        </li>
        <li>
          <Link href="/submit" className="text-green-400 hover:underline">
            Submit
          </Link>
        </li>
      </ul>
    </nav>
  );
}
